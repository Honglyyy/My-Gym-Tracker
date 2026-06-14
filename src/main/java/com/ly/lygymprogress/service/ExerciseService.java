package com.ly.lygymprogress.service;

import com.ly.lygymprogress.dto.ExerciseRequestDto;
import com.ly.lygymprogress.dto.ExerciseResponseDto;
import com.ly.lygymprogress.mapper.ExerciseMapper;
import com.ly.lygymprogress.model.Exercises;
import com.ly.lygymprogress.model.MuscleGroups;
import com.ly.lygymprogress.model.MuscleGroupsEnum;
import com.ly.lygymprogress.repository.ExercisesRepository;
import com.ly.lygymprogress.repository.MuscleGroupsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseService {
    private final ExercisesRepository exercisesRepository;
    private final ExerciseMapper exerciseMapper;
    private final MuscleGroupsRepository muscleGroupsRepository;

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

    public ExerciseResponseDto addExercise(ExerciseRequestDto dto) {
        Exercises exercise = new Exercises();
        exercise.setExerciseName(dto.exerciseName());

        if (dto.muscleGroupId() != null) {
            MuscleGroups muscleGroup = muscleGroupsRepository.findById(dto.muscleGroupId())
                    .orElseThrow(() -> new RuntimeException("Muscle group not found"));
            exercise.setMuscleGroup(muscleGroup);
        }

        return exerciseMapper.toDto(exercisesRepository.save(exercise));
    }

    public ExerciseResponseDto updateExercise(Long id, ExerciseRequestDto dto) {
        Exercises exercise = exercisesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exercise not found"));
        MuscleGroups muscleGroup = muscleGroupsRepository.findById(dto.muscleGroupId())
                .orElseThrow(() -> new RuntimeException("Muscle group not found"));
        exercise.setExerciseName(dto.exerciseName());
        exercise.setMuscleGroup(muscleGroup);
        exercisesRepository.save(exercise);
        return exerciseMapper.toDto(exercise);
    }

    public void deleteExercise(Long id) {
        exercisesRepository.deleteById(id);
    }
}
