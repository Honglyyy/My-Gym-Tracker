package com.ly.lygymprogress.dto;

import lombok.Builder;
import java.sql.Timestamp;

@Builder
public record WeightResponseDto(
        Long id,
        Double weightBefore,
        Double weightAfter,
        Timestamp createdAt
) {
}
