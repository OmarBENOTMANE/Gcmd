package org.backend.gdc.repository;

import org.backend.gdc.entity.LigneBpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneBpRepository extends JpaRepository<LigneBpEntity, Long> {
}