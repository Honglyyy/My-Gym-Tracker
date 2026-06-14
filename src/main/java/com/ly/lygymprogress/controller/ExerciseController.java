package com.ly.lygymprogress.controller;

import com.ly.lygymprogress.dto.ExerciseResponseDto;
import com.ly.lygymprogress.dto.WorkoutSetRequestDto;
import com.ly.lygymprogress.dto.WorkoutSetResponseDto;
import com.ly.lygymprogress.model.MuscleGroupsEnum;
import com.ly.lygymprogress.service.ExerciseService;
import com.ly.lygymprogress.service.WorkoutSetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ExerciseController {
    private final ExerciseService exerciseService;
    private final WorkoutSetService workoutSetService;

    @GetMapping("/exercises")
    ResponseEntity<List<ExerciseResponseDto>> findExercises(@RequestParam(required = false) MuscleGroupsEnum muscleGroup){
        return ResponseEntity.ok(exerciseService.findExercises(muscleGroup));
    }

    @GetMapping("/exercises/{id}/history")
    ResponseEntity<ExerciseResponseDto> getExerciseHistory(@PathVariable Long id){
        return ResponseEntity.ok(exerciseService.findExerciseById(id));
    }

    @DeleteMapping("/exercises/{id}")
    ResponseEntity<Void> deleteExercise(@PathVariable Long id){
        exerciseService.deleteExercise(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/exercises/sets")
    ResponseEntity<WorkoutSetResponseDto> addWorkoutSet(@RequestBody WorkoutSetRequestDto workoutSetRequestDto){
        return ResponseEntity.ok(workoutSetService.addWorkoutSet(workoutSetRequestDto));
    }

}
