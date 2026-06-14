package com.ly.lygymprogress.dto;

import com.ly.lygymprogress.model.MuscleGroupsEnum;
import lombok.Builder;

@Builder
public record MuscleGroupResponseDto(
        Long id,
        MuscleGroupsEnum muscleGroup
) {
}
