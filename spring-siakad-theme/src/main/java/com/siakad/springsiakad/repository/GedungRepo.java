package com.siakad.springsiakad.repository;

import com.siakad.springsiakad.entity.GedungEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GedungRepo extends JpaRepository<GedungEntity, String> {
}
