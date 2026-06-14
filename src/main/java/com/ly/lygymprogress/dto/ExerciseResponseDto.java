package com.ly.lygymprogress.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record ExerciseResponseDto(
        Long id,
        String exerciseName,
        String muscleGroup,
        List<WorkoutSetResponseDto> workoutSets
) {
}
