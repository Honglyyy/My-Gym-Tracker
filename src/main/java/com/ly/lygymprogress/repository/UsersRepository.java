package com.ly.lygymprogress.repository;

import com.ly.lygymprogress.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
}