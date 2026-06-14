package com.ly.lygymprogress.dto;

public record UserWeightRequestDto(
        Double weightBefore,
        Double weightAfter,
        Long userId
) {
}
