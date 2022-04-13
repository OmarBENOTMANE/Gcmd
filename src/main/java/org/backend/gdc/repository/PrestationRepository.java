package org.backend.gdc.repository;

import org.backend.gdc.entity.PrestationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestationRepository extends JpaRepository<PrestationEntity, Long> {
}