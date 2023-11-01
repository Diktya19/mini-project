package com.bootcamp.springmvc.repository;

import com.bootcamp.springmvc.entity.KameraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KameraRepo extends JpaRepository<KameraEntity, Integer> {
}
