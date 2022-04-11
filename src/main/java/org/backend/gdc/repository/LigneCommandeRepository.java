package org.backend.gdc.repository;

import org.backend.gdc.entity.LigneCommandeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCommandeRepository extends JpaRepository<LigneCommandeEntity, Long> {
}