package com.ly.lygymprogress.dto;

import lombok.Builder;

@Builder
public record ExerciseRequestDto(
        String exerciseName,
        Long muscleGroupId
) {
}
