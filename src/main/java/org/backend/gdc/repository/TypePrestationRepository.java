package org.backend.gdc.repository;

import org.backend.gdc.entity.TypePrestationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypePrestationRepository extends JpaRepository<TypePrestationEntity, Long> {
}