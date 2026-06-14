package com.ly.lygymprogress.dto;

import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record WorkoutSessionResponseDto(
        Long id,
        String sessionName,
        Long splitId,
        LocalDate sessionDate,
        List<ExerciseResponseDto> exercises,
        List<WorkoutSetResponseDto> workoutSets
) {
}
