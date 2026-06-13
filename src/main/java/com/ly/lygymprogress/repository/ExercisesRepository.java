package com.ly.lygymprogress.repository;

import com.ly.lygymprogress.model.Exercises;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExercisesRepository extends JpaRepository<Exercises, Long> {
}