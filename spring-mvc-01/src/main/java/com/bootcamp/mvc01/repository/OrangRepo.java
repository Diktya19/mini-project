package com.bootcamp.mvc01.repository;

import com.bootcamp.mvc01.entity.OrangEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrangRepo extends JpaRepository<OrangEntity, Integer> {
}
