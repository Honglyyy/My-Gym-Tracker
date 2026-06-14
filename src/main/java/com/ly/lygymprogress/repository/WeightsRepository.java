package com.ly.lygymprogress.repository;

import com.ly.lygymprogress.model.Weights;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WeightsRepository extends JpaRepository<Weights, Long> {
    Optional<Weights> findTopByUser_IdOrderByCreatedAtDesc(Long userId);
    java.util.List<Weights> findAllByUser_IdOrderByCreatedAtDesc(Long userId);
}