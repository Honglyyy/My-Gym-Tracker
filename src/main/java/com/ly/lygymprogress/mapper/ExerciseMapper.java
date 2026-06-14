package com.ly.lygymprogress.mapper;

import com.ly.lygymprogress.dto.ExerciseResponseDto;
import com.ly.lygymprogress.model.Exercises;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
@RequiredArgsConstructor
public class ExerciseMapper {
    private final WorkoutSetMapper workoutSetMapper;

    public ExerciseResponseDto toDto(Exercises exercises) {
        if (exercises == null) {
            return null;
        }

        String muscleGroupName = null;
        if (exercises.getMuscleGroup() != null && exercises.getMuscleGroup().getMuscleGroups() != null) {
            muscleGroupName = exercises.getMuscleGroup().getMuscleGroups().name();
        }

        return ExerciseResponseDto.builder()
                .id(exercises.getId())
                .exerciseName(exercises.getExerciseName())
                .muscleGroup(muscleGroupName)
                .workoutSets(exercises.getWorkoutSets() != null
                        ? exercises.getWorkoutSets().stream().map(workoutSetMapper::toDto).toList()
                        : Collections.emptyList())
                .build();
    }
}
