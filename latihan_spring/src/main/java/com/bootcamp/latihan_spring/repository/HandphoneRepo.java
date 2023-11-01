package com.bootcamp.latihan_spring.repository;

import com.bootcamp.latihan_spring.entity.HandphoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HandphoneRepo extends JpaRepository<HandphoneEntity, Integer> {
}
