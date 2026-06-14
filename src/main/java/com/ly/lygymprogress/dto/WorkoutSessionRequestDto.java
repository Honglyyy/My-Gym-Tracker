package com.ly.lygymprogress.dto;

import lombok.Builder;

@Builder
public record WorkoutSessionRequestDto(
        String sessionName,
        Long splitId
) {
}
