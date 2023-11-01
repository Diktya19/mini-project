package com.bootcamp.belajarspringjpa1.repository;

import com.bootcamp.belajarspringjpa1.entity.PropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepo extends JpaRepository<PropertyEntity, Integer> {
}
