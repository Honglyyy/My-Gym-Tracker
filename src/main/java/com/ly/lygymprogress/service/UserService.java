package com.ly.lygymprogress.service;

import com.ly.lygymprogress.dto.UserRequestDto;
import com.ly.lygymprogress.dto.UserResponseDto;
import com.ly.lygymprogress.model.Users;
import com.ly.lygymprogress.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UsersRepository usersRepository;

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
        user.setWeightBefore(request.weightBefore());
        user.setWeightAfter(request.weightAfter());
        user.setHeight(request.height());

        Users savedUser = usersRepository.save(user);

        return UserResponseDto.builder()
                .username(savedUser.getUsername())
                .age(savedUser.getAge())
                .weightBefore(savedUser.getWeightBefore())
                .weightAfter(savedUser.getWeightAfter())
                .height(savedUser.getHeight())
                .build();
    }

    public void deleteUser(Long id){
        usersRepository.deleteById(id);
    }

    public UserResponseDto updateUser(Long id, UserRequestDto dto){
        Users existingUser = usersRepository.findById(id).orElseThrow(()->new RuntimeException("User not found!!"));

        existingUser.setUsername(dto.username());
        existingUser.setAge(dto.age());
        existingUser.setWeightBefore(dto.weightBefore());
        existingUser.setWeightAfter(dto.weightAfter());
        existingUser.setHeight(dto.height());

        usersRepository.save(existingUser);
        return UserResponseDto.builder()
                .username(existingUser.getUsername()).age(existingUser.getAge()).weightBefore(existingUser.getWeightBefore()).weightAfter(existingUser.getWeightAfter()).height(existingUser.getHeight()).build();
    }
}
