package com.ly.lygymprogress.repository;

import com.ly.lygymprogress.model.Exercises;
import com.ly.lygymprogress.model.MuscleGroupsEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExercisesRepository extends JpaRepository<Exercises, Long> {
    List<Exercises> findByMuscleGroup_MuscleGroups(MuscleGroupsEnum muscleGroup);
}
