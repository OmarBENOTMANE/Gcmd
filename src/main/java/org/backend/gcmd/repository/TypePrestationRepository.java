package org.backend.gcmd.repository;

import org.backend.gcmd.entity.TypePrestationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypePrestationRepository extends JpaRepository<TypePrestationEntity, Long> {
}