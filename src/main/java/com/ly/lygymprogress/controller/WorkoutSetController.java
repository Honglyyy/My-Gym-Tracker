package com.ly.lygymprogress.controller;

import com.ly.lygymprogress.dto.WorkoutSetRequestDto;
import com.ly.lygymprogress.dto.WorkoutSetResponseDto;
import com.ly.lygymprogress.service.WorkoutSetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/workout-sets")
public class WorkoutSetController {
    private final WorkoutSetService workoutSetService;

    @PostMapping
    ResponseEntity<WorkoutSetResponseDto> addWorkoutSet(@RequestBody WorkoutSetRequestDto dto){
        return ResponseEntity.ok(workoutSetService.addWorkoutSet(dto));
    }

    @PutMapping("/{id}")
    ResponseEntity<WorkoutSetResponseDto> updateWorkoutSet(@PathVariable Long id, @RequestBody WorkoutSetRequestDto dto){
        return ResponseEntity.ok(workoutSetService.updateWorkoutSet(id, dto));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteWorkoutSet(@PathVariable Long id){
        workoutSetService.deleteWorkoutSet(id);
        return ResponseEntity.noContent().build();
    }
}
