package com.ly.lygymprogress.dto;

import lombok.Builder;

@Builder
public record SplitRequestDto(
        String splitName
) {
}
