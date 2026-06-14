package com.ly.lygymprogress.dto;

import com.ly.lygymprogress.model.Exercises;
import com.ly.lygymprogress.model.WorkoutSessions;
import lombok.Builder;

import java.util.List;

@Builder
public record SplitResponseDto(
        Long id,
        String splitName,
        List<WorkoutSessions> workoutSessions
) {
}
