package com.ly.lygymprogress.controller;

import com.ly.lygymprogress.dto.WorkoutSessionRequestDto;
import com.ly.lygymprogress.dto.WorkoutSessionResponseDto;
import com.ly.lygymprogress.service.WorkoutSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class WorkoutSessionController {
    private final WorkoutSessionService workoutSessionService;

    @GetMapping("/workout-sessions")
    ResponseEntity<List<WorkoutSessionResponseDto>> findWorkoutSessions(){
        return ResponseEntity.ok(workoutSessionService.findWorkoutSessions());
    }

    @PostMapping("/workout-sessions")
    ResponseEntity<WorkoutSessionResponseDto> addWorkoutSession(@RequestBody WorkoutSessionRequestDto dto){
        return ResponseEntity.ok(workoutSessionService.addWorkoutSession(dto));
    }

    @PutMapping("/workout-sessions/{id}")
    ResponseEntity<WorkoutSessionResponseDto> updateWorkoutSession(@PathVariable Long id, @RequestBody WorkoutSessionRequestDto dto){
        return ResponseEntity.ok(workoutSessionService.updateWorkoutSession(id,dto));
    }

    @DeleteMapping("/workout-sessions/{id}")
    ResponseEntity<String> deleteWorkoutSession(@PathVariable Long id){
        workoutSessionService.deleteWorkoutSession(id);
        return ResponseEntity.ok("Workout session is delete!");
    }
}
