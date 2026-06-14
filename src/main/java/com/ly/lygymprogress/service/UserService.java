package com.ly.lygymprogress.service;

import com.ly.lygymprogress.dto.*;
import com.ly.lygymprogress.model.Users;
import com.ly.lygymprogress.model.Weights;
import com.ly.lygymprogress.repository.UsersRepository;
import com.ly.lygymprogress.repository.WeightsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UsersRepository usersRepository;
    private final WeightsRepository weightsRepository;

    public List<UserResponseDto> findUsers(){
        return usersRepository.findAll().stream()
                .map(user -> UserResponseDto.builder()
                        .username(user.getUsername())
                        .age(user.getAge())
                        .height(user.getHeight())
                        .build())
                .toList();
    }

    public Optional<Users> findUser(Long id){
        return usersRepository.findById(id);
    }

    public UserResponseDto addUser(UserRequestDto request) {
        Users user = new Users();
        user.setUsername(request.username());
        user.setAge(request.age());
        user.setHeight(request.height());
        Users savedUser = usersRepository.save(user);

        return UserResponseDto.builder()
                .username(savedUser.getUsername())
                .age(savedUser.getAge())
                .height(savedUser.getHeight())
                .build();
    }

    public UserResponseDto updateUser(Long id, UserRequestDto request) {
        Users user = usersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setUsername(request.username());
        user.setAge(request.age());
        user.setHeight(request.height());
        usersRepository.save(user);
        return UserResponseDto.builder()
                .username(user.getUsername())
                .age(user.getAge())
                .height(user.getHeight())
                .build();
    }

    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }

    public UserWeightResponseDto findUserWithWeight(Long id) {
        Users user = usersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Weights latestWeight = weightsRepository
                .findTopByUser_IdOrderByCreatedAtDesc(id)
                .orElse(null);

        return new UserWeightResponseDto(
                user.getUsername(),
                user.getAge(),
                latestWeight != null ? latestWeight.getWeightBefore() : null,
                latestWeight != null ? latestWeight.getWeightAfter() : null,
                user.getHeight()
        );
    }

    public UserWeightResponseDto updateUserWeight(UserWeightRequestDto dto) {
        Users existingUser = usersRepository.findById(dto.userId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Weights weight = new Weights();
        weight.setWeightBefore(dto.weightBefore());
        weight.setWeightAfter(dto.weightAfter());
        weight.setUser(existingUser);

        weightsRepository.save(weight);

        return new UserWeightResponseDto(
                existingUser.getUsername(),
                existingUser.getAge(),
                weight.getWeightBefore(),
                weight.getWeightAfter(),
                existingUser.getHeight()
        );
    }

    public List<WeightResponseDto> findWeightHistory(Long userId) {
        return weightsRepository.findAllByUser_IdOrderByCreatedAtDesc(userId).stream()
                .map(weight -> WeightResponseDto.builder()
                        .id(weight.getId())
                        .weightBefore(weight.getWeightBefore())
                        .weightAfter(weight.getWeightAfter())
                        .createdAt(weight.getCreatedAt())
                        .build())
                .collect(Collectors.toList());
    }
}
