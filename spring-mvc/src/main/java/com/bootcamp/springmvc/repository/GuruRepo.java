package com.bootcamp.springmvc.repository;

import com.bootcamp.springmvc.entity.GuruEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuruRepo extends JpaRepository<GuruEntity, Integer> {
}
