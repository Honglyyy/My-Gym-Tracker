package com.ly.lygymprogress.repository;

import com.ly.lygymprogress.model.MuscleGroups;
import com.ly.lygymprogress.model.MuscleGroupsEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MuscleGroupsRepository extends JpaRepository<MuscleGroups, Long> {
    Optional<MuscleGroups> findByMuscleGroups(MuscleGroupsEnum muscleGroupsEnum);
}