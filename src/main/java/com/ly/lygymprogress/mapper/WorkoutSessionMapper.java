package com.ly.lygymprogress.mapper;

import com.ly.lygymprogress.dto.WorkoutSessionResponseDto;
import com.ly.lygymprogress.model.WorkoutSessions;
import org.springframework.stereotype.Component;

@Component
public class WorkoutSessionMapper {

    public WorkoutSessionResponseDto toDto(WorkoutSessions workoutSession){
        return WorkoutSessionResponseDto.builder()
                .sessionName(workoutSession.getSessionName())
                .splitId(workoutSession.getSplit().getId())
                .exercises(workoutSession.getExercises())
                .build();
    }

}
