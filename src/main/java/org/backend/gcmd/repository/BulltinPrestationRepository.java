package org.backend.gcmd.repository;

import org.backend.gcmd.entity.BulltinPrestationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BulltinPrestationRepository extends JpaRepository<BulltinPrestationEntity, Long> {
}