package com.ly.lygymprogress.repository;

import com.ly.lygymprogress.model.WorkoutSessions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutSessionsRepository extends JpaRepository<WorkoutSessions, Long> {
    List<WorkoutSessions> findAllByOrderBySessionDateDescIdDesc();
}
