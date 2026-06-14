package com.ly.lygymprogress.controller;

import com.ly.lygymprogress.dto.UserRequestDto;
import com.ly.lygymprogress.dto.UserResponseDto;
import com.ly.lygymprogress.dto.UserWeightRequestDto;
import com.ly.lygymprogress.dto.UserWeightResponseDto;
import com.ly.lygymprogress.model.Users;
import com.ly.lygymprogress.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    ResponseEntity<List<Users>> findUsers(){
        return ResponseEntity.ok(userService.findUsers());
    }

    @GetMapping("/users/{id}")
    ResponseEntity<UserWeightResponseDto> findUser(@PathVariable Long id){
        return ResponseEntity.ok(userService.findUserWithWeight(id));
    }

    @PostMapping("/users")
    ResponseEntity<UserResponseDto> addUser(@RequestBody UserRequestDto dto){
        return ResponseEntity.ok(userService.addUser(dto));
    }

    @PostMapping("/users/weights")
    ResponseEntity<UserWeightResponseDto> updateWeight(
            @RequestBody UserWeightRequestDto dto
            ){
        return ResponseEntity.ok(userService.updateUserWeight(dto));
    }
}
