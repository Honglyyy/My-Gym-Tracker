package com.ly.lygymprogress.repository;

import com.ly.lygymprogress.model.Splits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SplitsRepository extends JpaRepository<Splits, Long> {
}