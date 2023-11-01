package com.bootcamp.webhtml3.repository;

import com.bootcamp.webhtml3.entity.OrangEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrangRepo extends JpaRepository<OrangEntity, Integer> {
}
