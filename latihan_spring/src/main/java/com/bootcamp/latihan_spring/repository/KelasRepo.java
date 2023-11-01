package com.bootcamp.latihan_spring.repository;

import com.bootcamp.latihan_spring.entity.KelasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KelasRepo extends JpaRepository<KelasEntity, Integer> {
}
