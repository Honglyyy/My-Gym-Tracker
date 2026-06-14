package com.ly.lygymprogress.service;

import com.ly.lygymprogress.dto.WorkoutSetRequestDto;
import com.ly.lygymprogress.dto.WorkoutSetResponseDto;
import com.ly.lygymprogress.mapper.WorkoutSetMapper;
import com.ly.lygymprogress.model.Exercises;
import com.ly.lygymprogress.model.WorkoutSets;
import com.ly.lygymprogress.repository.ExercisesRepository;
import com.ly.lygymprogress.repository.WorkoutSetsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkoutSetService {
    private final WorkoutSetsRepository workoutSetsRepository;
    private final ExercisesRepository exercisesRepository;
    private final WorkoutSetMapper workoutSetMapper;

    public WorkoutSetResponseDto addWorkoutSet(WorkoutSetRequestDto workoutSetRequestDto) {
        Exercises exercise = exercisesRepository.findById(workoutSetRequestDto.exerciseId())
                .orElseThrow(() -> new RuntimeException("Exercise not found"));

        WorkoutSets workoutSet = new WorkoutSets();
        workoutSet.setExercise(exercise);
        workoutSet.setReps(workoutSetRequestDto.reps());
        workoutSet.setWeight(workoutSetRequestDto.weight());

        WorkoutSets savedSet = workoutSetsRepository.save(workoutSet);
        return workoutSetMapper.toDto(savedSet);
    }
}
