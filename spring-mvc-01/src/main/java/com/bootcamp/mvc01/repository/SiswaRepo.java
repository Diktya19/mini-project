package com.bootcamp.mvc01.repository;

import com.bootcamp.mvc01.entity.SiswaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiswaRepo extends JpaRepository<SiswaEntity, Integer> {
}
