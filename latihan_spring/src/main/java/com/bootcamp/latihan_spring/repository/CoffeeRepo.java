package com.bootcamp.latihan_spring.repository;

import com.bootcamp.latihan_spring.entity.CoffeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeRepo extends JpaRepository<CoffeeEntity, Integer> {
}
