package com.bootcamp.springmvc.repository;

import com.bootcamp.springmvc.entity.LaptopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepo extends JpaRepository<LaptopEntity, Integer> {
}
