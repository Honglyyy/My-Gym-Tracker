package com.ly.lygymprogress.controller;

import com.ly.lygymprogress.dto.MuscleGroupResponseDto;
import com.ly.lygymprogress.service.MuscleGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/muscle-groups")
public class MuscleGroupController {
    private final MuscleGroupService muscleGroupService;

    @GetMapping
    ResponseEntity<List<MuscleGroupResponseDto>> findMuscleGroups(){
        return ResponseEntity.ok(muscleGroupService.findMuscleGroups());
    }

    // Since MuscleGroups are tied to an Enum, we only support retrieval
    // However, if we wanted to manage them as entities, we'd add POST/PUT/DELETE here.
    // For now, retrieval is the primary operation for the UI to function.
}
