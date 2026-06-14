package com.ly.lygymprogress.dto;

import lombok.Builder;

@Builder
public record WorkoutSetResponseDto(
        Long id,
        String reps,
        String weight
) {
}
