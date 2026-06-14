package com.ly.lygymprogress.dto;

import lombok.Builder;

@Builder
public record WorkoutSetRequestDto(
        Long exerciseId,
        String reps,
        String weight
) {
}
