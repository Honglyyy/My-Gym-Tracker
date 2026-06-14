package com.ly.lygymprogress.dto;

import lombok.Builder;

@Builder
public record WorkoutSetRequestDto(
        Long exerciseId,
        Long workoutSessionId,
        String reps,
        String weight
) {
}
