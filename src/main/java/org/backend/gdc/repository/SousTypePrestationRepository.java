package org.backend.gdc.repository;

import org.backend.gdc.entity.ClientEntity;
import org.backend.gdc.entity.SousTypePrestationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SousTypePrestationRepository extends JpaRepository<SousTypePrestationEntity, Long> {
}