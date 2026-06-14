package com.ly.lygymprogress.dto;

import lombok.Builder;
import java.util.List;

@Builder
public record SplitSessionResponseDto(
        Long id,
        String sessionName,
        List<ExerciseResponseDto> exercises
) {
}
