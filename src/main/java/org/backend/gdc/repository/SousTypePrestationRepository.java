package org.backend.gdc.repository;

import org.backend.gdc.entity.SousTypePrestationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SousTypePrestationRepository extends JpaRepository<SousTypePrestationEntity, Long> {
}