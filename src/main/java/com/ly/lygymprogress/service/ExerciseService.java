package com.ly.lygymprogress.service;

import com.ly.lygymprogress.dto.ExerciseResponseDto;
import com.ly.lygymprogress.mapper.ExerciseMapper;
import com.ly.lygymprogress.model.Exercises;
import com.ly.lygymprogress.model.MuscleGroupsEnum;
import com.ly.lygymprogress.repository.ExercisesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseService {
    private final ExercisesRepository exercisesRepository;
    private final ExerciseMapper exerciseMapper;

    public List<ExerciseResponseDto> findExercises(MuscleGroupsEnum muscleGroup) {
        if (muscleGroup != null) {
            return exercisesRepository.findByMuscleGroup_MuscleGroups(muscleGroup)
                    .stream().map(exerciseMapper::toDto).toList();
        }
        return exercisesRepository.findAll().stream().map(exerciseMapper::toDto).toList();
    }

    public ExerciseResponseDto findExerciseById(Long id) {
        return exercisesRepository.findById(id)
                .map(exerciseMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Exercise not found"));
    }

    public void deleteExercise(Long id) {
        exercisesRepository.deleteById(id);
    }
}
