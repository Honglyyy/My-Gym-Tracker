package com.ly.lygymprogress.dto;

import lombok.Builder;

@Builder
public record WorkoutSetResponseDto(
        Long id,
        Long exerciseId,
        String exerciseName,
        Long workoutSessionId,
        String reps,
        String weight
) {
}
