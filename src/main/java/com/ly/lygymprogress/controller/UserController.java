package com.ly.lygymprogress.controller;

import com.ly.lygymprogress.dto.*;
import com.ly.lygymprogress.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    ResponseEntity<List<UserResponseDto>> findUsers(){
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

    @PutMapping("/users/{id}")
    ResponseEntity<UserResponseDto> updateUser(@PathVariable Long id, @RequestBody UserRequestDto dto){
        return ResponseEntity.ok(userService.updateUser(id, dto));
    }

    @DeleteMapping("/users/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/users/{id}/weights")
    ResponseEntity<List<WeightResponseDto>> findWeightHistory(@PathVariable Long id){
        return ResponseEntity.ok(userService.findWeightHistory(id));
    }

    @PostMapping("/users/weights")
    ResponseEntity<UserWeightResponseDto> updateWeight(@RequestBody UserWeightRequestDto dto){
        return ResponseEntity.ok(userService.updateUserWeight(dto));
    }
}
