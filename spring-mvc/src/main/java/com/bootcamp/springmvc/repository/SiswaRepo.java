package com.bootcamp.springmvc.repository;

import com.bootcamp.springmvc.entity.SiswaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiswaRepo extends JpaRepository<SiswaEntity, Integer> {
}
