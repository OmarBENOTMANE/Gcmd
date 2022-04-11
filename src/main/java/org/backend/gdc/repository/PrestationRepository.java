package org.backend.gdc.repository;

import org.backend.gdc.entity.PrestationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestationRepository extends JpaRepository<PrestationEntity, Long> {
}