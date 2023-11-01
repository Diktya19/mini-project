package com.siakad.springsiakad.repository;

import com.siakad.springsiakad.entity.KelasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KelasRepo extends JpaRepository<KelasEntity, String> {
}
