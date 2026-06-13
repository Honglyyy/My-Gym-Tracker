package com.ly.lygymprogress.controller;

import com.ly.lygymprogress.dto.UserRequestDto;
import com.ly.lygymprogress.dto.UserResponseDto;
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
    ResponseEntity<Optional<Users>> findUser(@PathVariable Long id){
        return ResponseEntity.ok(userService.findUser(id));
    }

    @PostMapping("/users")
    ResponseEntity<UserResponseDto> addUser(@RequestBody UserRequestDto dto){
        return ResponseEntity.ok(userService.addUser(dto));
    }

    @DeleteMapping("/users/{id}")
    ResponseEntity<String> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok("User id " + id + " is deleted!!");
    }

    @PutMapping("/users/{id}")
    ResponseEntity<UserResponseDto> updateUser(@PathVariable Long id, @RequestBody UserRequestDto dto){
        return ResponseEntity.ok(userService.updateUser(id,dto));
    }
}
