package com.bootcamp.belajarspringjpa1.repository;

import com.bootcamp.belajarspringjpa1.entity.OrangEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrangRepo extends JpaRepository<OrangEntity, Integer> {
}
