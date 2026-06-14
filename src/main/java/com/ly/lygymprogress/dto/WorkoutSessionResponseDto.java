package com.ly.lygymprogress.dto;

import com.ly.lygymprogress.model.Exercises;
import lombok.Builder;

import java.util.List;

@Builder
public record WorkoutSessionResponseDto(
        String sessionName,
        Long splitId,
        List<Exercises> exercises
) {
}
