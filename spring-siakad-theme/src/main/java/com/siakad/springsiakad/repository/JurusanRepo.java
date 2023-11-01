package com.siakad.springsiakad.repository;

import com.siakad.springsiakad.entity.JurusanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JurusanRepo extends JpaRepository<JurusanEntity, String>{
}
