package com.ly.lygymprogress.dto;

import lombok.Builder;

@Builder
public record UserResponseDto(
        String username,
        Long age,
        Double height
) {
}
