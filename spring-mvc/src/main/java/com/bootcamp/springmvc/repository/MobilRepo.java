package com.bootcamp.springmvc.repository;

import com.bootcamp.springmvc.entity.MobilEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobilRepo extends JpaRepository<MobilEntity, Integer> {
}
