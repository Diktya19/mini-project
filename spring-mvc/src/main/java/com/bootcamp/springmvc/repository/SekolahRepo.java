package com.bootcamp.springmvc.repository;

import com.bootcamp.springmvc.entity.SekolahEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SekolahRepo extends JpaRepository<SekolahEntity, Integer> {
}
