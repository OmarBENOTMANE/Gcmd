package org.backend.gdc.repository;

import org.backend.gdc.entity.TypeClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeClientRepository extends JpaRepository<TypeClientEntity, Long> {
}