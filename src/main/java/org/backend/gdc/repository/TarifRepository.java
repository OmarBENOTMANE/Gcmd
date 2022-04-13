package org.backend.gdc.repository;

import org.backend.gdc.entity.TarifEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarifRepository extends JpaRepository<TarifEntity, Long> {
}