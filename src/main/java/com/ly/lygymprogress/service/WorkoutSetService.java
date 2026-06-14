package com.ly.lygymprogress.service;

import com.ly.lygymprogress.dto.WorkoutSetRequestDto;
import com.ly.lygymprogress.dto.WorkoutSetResponseDto;
import com.ly.lygymprogress.mapper.WorkoutSetMapper;
import com.ly.lygymprogress.model.Exercises;
import com.ly.lygymprogress.model.WorkoutSessions;
import com.ly.lygymprogress.model.WorkoutSets;
import com.ly.lygymprogress.repository.ExercisesRepository;
import com.ly.lygymprogress.repository.WorkoutSessionsRepository;
import com.ly.lygymprogress.repository.WorkoutSetsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkoutSetService {
    private final WorkoutSetsRepository workoutSetsRepository;
    private final ExercisesRepository exercisesRepository;
    private final WorkoutSessionsRepository workoutSessionsRepository;
    private final WorkoutSetMapper workoutSetMapper;

    public WorkoutSetResponseDto addWorkoutSet(WorkoutSetRequestDto workoutSetRequestDto) {
        Exercises exercise = exercisesRepository.findById(workoutSetRequestDto.exerciseId())
                .orElseThrow(() -> new RuntimeException("Exercise not found"));
        WorkoutSessions workoutSession = workoutSessionsRepository.findById(workoutSetRequestDto.workoutSessionId())
                .orElseThrow(() -> new RuntimeException("Workout session not found"));

        boolean exerciseBelongsToSplit = workoutSession.getSplit() != null
                && workoutSession.getSplit().getSessions() != null
                && workoutSession.getSplit().getSessions().stream()
                .flatMap(session -> session.getExercises().stream())
                .anyMatch(splitExercise -> splitExercise.getId().equals(exercise.getId()));

        if (!exerciseBelongsToSplit) {
            throw new RuntimeException("Exercise is not part of this workout session's split");
        }

        WorkoutSets workoutSet = new WorkoutSets();
        workoutSet.setExercise(exercise);
        workoutSet.setWorkoutSession(workoutSession);
        workoutSet.setReps(workoutSetRequestDto.reps());
        workoutSet.setWeight(workoutSetRequestDto.weight());

        WorkoutSets savedSet = workoutSetsRepository.save(workoutSet);
        return workoutSetMapper.toDto(savedSet);
    }

    public WorkoutSetResponseDto updateWorkoutSet(Long id, WorkoutSetRequestDto dto) {
        WorkoutSets workoutSet = workoutSetsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Workout set not found"));
        workoutSet.setReps(dto.reps());
        workoutSet.setWeight(dto.weight());
        workoutSetsRepository.save(workoutSet);
        return workoutSetMapper.toDto(workoutSet);
    }

    public void deleteWorkoutSet(Long id) {
        workoutSetsRepository.deleteById(id);
    }
}
