package com.ly.lygymprogress.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record SplitResponseDto(
        Long id,
        String splitName,
        List<SplitSessionResponseDto> sessions,
        List<WorkoutSessionResponseDto> workoutSessions
) {
}
