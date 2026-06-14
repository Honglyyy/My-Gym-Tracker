package com.ly.lygymprogress.dto;

import com.ly.lygymprogress.model.MuscleGroups;
import com.ly.lygymprogress.model.WorkoutSessions;
import com.ly.lygymprogress.model.WorkoutSets;
import lombok.Builder;

import java.util.List;

@Builder
public record ExerciseRequestDto(
        String exerciseName,
        MuscleGroups muscleGroupId,
        WorkoutSessions workoutSessionId
) {
}
