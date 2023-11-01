package com.siakad.springsiakad.repository;

import com.siakad.springsiakad.entity.FakultasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FakultasRepo extends JpaRepository<FakultasEntity, String> {
}
