package com.ly.lygymprogress.dto;

public record UserRequestDto(
        String username,
        Long age,
        Double weightBefore,
        Double weightAfter,
        Double height
) {
}
