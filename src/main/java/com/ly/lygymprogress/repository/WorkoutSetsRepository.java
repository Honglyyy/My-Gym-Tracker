package com.ly.lygymprogress.repository;

import com.ly.lygymprogress.model.WorkoutSets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutSetsRepository extends JpaRepository<WorkoutSets, Long> {
}