package com.ly.lygymprogress.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record SplitRequestDto(
        String splitName,
        List<SplitSessionRequestDto> sessions
) {
}
