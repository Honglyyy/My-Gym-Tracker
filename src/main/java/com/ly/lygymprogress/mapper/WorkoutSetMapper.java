package com.ly.lygymprogress.mapper;

import com.ly.lygymprogress.dto.WorkoutSetResponseDto;
import com.ly.lygymprogress.model.WorkoutSets;
import org.springframework.stereotype.Component;

@Component
public class WorkoutSetMapper {
    public WorkoutSetResponseDto toDto(WorkoutSets workoutSets) {
        if (workoutSets == null) {
            return null;
        }
        return WorkoutSetResponseDto.builder()
                .id(workoutSets.getId())
                .reps(workoutSets.getReps())
                .weight(workoutSets.getWeight())
                .build();
    }
}
