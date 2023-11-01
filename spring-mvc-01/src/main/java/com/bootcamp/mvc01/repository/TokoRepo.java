package com.bootcamp.mvc01.repository;

import com.bootcamp.mvc01.entity.TokoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokoRepo extends JpaRepository<TokoEntity, Integer> {
}
