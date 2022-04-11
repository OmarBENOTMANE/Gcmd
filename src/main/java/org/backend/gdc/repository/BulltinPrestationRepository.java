package org.backend.gdc.repository;

import org.backend.gdc.entity.BulltinPrestationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface BulltinPrestationRepository extends JpaRepository<BulltinPrestationEntity, Long> {
}