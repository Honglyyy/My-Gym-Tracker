package com.ly.lygymprogress.mapper;

import com.ly.lygymprogress.dto.WorkoutSessionResponseDto;
import com.ly.lygymprogress.model.WorkoutSessions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
@RequiredArgsConstructor
public class WorkoutSessionMapper {
    private final ExerciseMapper exerciseMapper;
    private final WorkoutSetMapper workoutSetMapper;

    public WorkoutSessionResponseDto toDto(WorkoutSessions workoutSession){
        return WorkoutSessionResponseDto.builder()
                .id(workoutSession.getId())
                .sessionName(workoutSession.getSessionName())
                .splitId(workoutSession.getSplit().getId())
                .sessionDate(workoutSession.getSessionDate())
                .exercises(workoutSession.getSplit().getSessions() != null
                        ? workoutSession.getSplit().getSessions().stream()
                            .filter(s -> s.getSessionName().equals(workoutSession.getSessionName()))
                            .findFirst()
                            .map(s -> s.getExercises().stream().map(exerciseMapper::toDto).toList())
                            .orElse(Collections.emptyList())
                        : Collections.emptyList())
                .workoutSets(workoutSession.getWorkoutSets() != null
                        ? workoutSession.getWorkoutSets().stream().map(workoutSetMapper::toDto).toList()
                        : Collections.emptyList())
                .build();
    }

}
