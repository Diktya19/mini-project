package com.bootcamp.latihan_spring.repository;

import com.bootcamp.latihan_spring.entity.CafeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CafeRepo extends JpaRepository<CafeEntity, Integer> {
}
