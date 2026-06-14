package com.ly.lygymprogress.dto;

public record UserWeightResponseDto(
        String username,
        Long age,
        Double weightBefore,
        Double weightAfter,
        Double height
) {
}
