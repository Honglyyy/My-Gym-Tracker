package com.ly.lygymprogress.service;

import com.ly.lygymprogress.dto.UserRequestDto;
import com.ly.lygymprogress.dto.UserResponseDto;
import com.ly.lygymprogress.dto.UserWeightRequestDto;
import com.ly.lygymprogress.dto.UserWeightResponseDto;
import com.ly.lygymprogress.model.Users;
import com.ly.lygymprogress.model.Weights;
import com.ly.lygymprogress.repository.UsersRepository;
import com.ly.lygymprogress.repository.WeightsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UsersRepository usersRepository;
    private  final WeightsRepository weightsRepository;

    public List<Users> findUsers(){
        return usersRepository.findAll();
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

    public UserWeightResponseDto findUserWithWeight(Long id) {

        Users user = usersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Weights latestWeight = weightsRepository
                .findTopByUser_IdOrderByCreatedAtDesc(id)
                .orElseThrow(() -> new RuntimeException("Weight not found"));

        return new UserWeightResponseDto(
                user.getUsername(),
                user.getAge(),
                latestWeight.getWeightBefore(),
                latestWeight.getWeightAfter(),
                user.getHeight()
        );
    }


    public UserWeightResponseDto updateUserWeight(UserWeightRequestDto dto) {
        Users existingUser = usersRepository.findById(dto.userId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Weights latestWeight = new Weights();
        latestWeight.setWeightBefore(dto.weightBefore());
        latestWeight.setWeightAfter(dto.weightAfter());

        latestWeight.setUser(existingUser);

        weightsRepository.save(latestWeight);

        return new UserWeightResponseDto(
                existingUser.getUsername(),
                existingUser.getAge(),
                latestWeight.getWeightBefore(),
                latestWeight.getWeightAfter(),
                existingUser.getHeight()
        );
    }
}
