package com.bootcamp.latihan_spring.repository;

import com.bootcamp.latihan_spring.entity.GuruEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuruRepo extends JpaRepository<GuruEntity, Integer > {
}
