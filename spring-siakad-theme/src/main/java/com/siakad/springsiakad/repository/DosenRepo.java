package com.siakad.springsiakad.repository;

import com.siakad.springsiakad.entity.DosenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DosenRepo extends JpaRepository<DosenEntity, String> {
}
