package com.ly.lygymprogress.dto;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record WorkoutSessionRequestDto(
        String sessionName,
        Long splitId,
        LocalDate sessionDate
) {
}
