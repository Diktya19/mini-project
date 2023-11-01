package com.bootcamp.belajarspringjpa1.repository;

import com.bootcamp.belajarspringjpa1.entity.MotorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorRepo extends JpaRepository<MotorEntity, Integer> {
}
