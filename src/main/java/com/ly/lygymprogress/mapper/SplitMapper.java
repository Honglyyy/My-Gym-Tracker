package com.ly.lygymprogress.mapper;

import com.ly.lygymprogress.dto.SplitResponseDto;
import com.ly.lygymprogress.model.Splits;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
@RequiredArgsConstructor
public class SplitMapper {
    private final WorkoutSessionMapper workoutSessionMapper;
    private final ExerciseMapper exerciseMapper;

    public SplitResponseDto toDto(Splits split){
        return SplitResponseDto.builder()
                .id(split.getId())
                .splitName(split.getSplitName())
                .sessions(split.getSessions() != null
                        ? split.getSessions().stream().map(this::toSessionDto).toList()
                        : Collections.emptyList())
                .workoutSessions(split.getWorkoutSessions() != null
                        ? split.getWorkoutSessions().stream().map(workoutSessionMapper::toDto).toList()
                        : Collections.emptyList())
                .build();
    }

    private com.ly.lygymprogress.dto.SplitSessionResponseDto toSessionDto(com.ly.lygymprogress.model.SplitSession session) {
        return com.ly.lygymprogress.dto.SplitSessionResponseDto.builder()
                .id(session.getId())
                .sessionName(session.getSessionName())
                .exercises(session.getExercises() != null
                        ? session.getExercises().stream().map(exerciseMapper::toDto).toList()
                        : Collections.emptyList())
                .build();
    }


}
