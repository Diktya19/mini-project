package com.bootcamp.latihan_spring.repository;

import com.bootcamp.latihan_spring.entity.GudangEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GudangRepo extends JpaRepository<GudangEntity, Integer>{
}
