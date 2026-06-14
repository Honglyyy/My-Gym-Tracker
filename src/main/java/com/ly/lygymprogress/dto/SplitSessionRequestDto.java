package com.ly.lygymprogress.dto;

import lombok.Builder;
import java.util.List;

@Builder
public record SplitSessionRequestDto(
        String sessionName,
        List<Long> exerciseIds
) {
}
