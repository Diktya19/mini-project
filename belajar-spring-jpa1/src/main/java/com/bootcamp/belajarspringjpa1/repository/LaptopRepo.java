package com.bootcamp.belajarspringjpa1.repository;

import com.bootcamp.belajarspringjpa1.entity.LaptopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepo extends JpaRepository<LaptopEntity, Integer> {
}
