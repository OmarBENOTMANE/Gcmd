package org.backend.gdc.repository;

import org.backend.gdc.entity.EscaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EscaleRepository extends JpaRepository<EscaleEntity, Long> {
}