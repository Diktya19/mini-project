package com.bootcamp.springmvc.repository;

import com.bootcamp.springmvc.entity.BukuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BukuRepo extends JpaRepository<BukuEntity, Integer> {
}
