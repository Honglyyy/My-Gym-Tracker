package com.ly.lygymprogress.controller;

import com.ly.lygymprogress.model.MuscleGroups;
import com.ly.lygymprogress.service.MuscleGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MuscleGroupController {
    private final MuscleGroupService muscleGroupService;

    @GetMapping("/muscle-groups")
    ResponseEntity<List<MuscleGroups>> findMuscleGroups(){
        return ResponseEntity.ok(muscleGroupService.findMuscleGroups());
    }
}
