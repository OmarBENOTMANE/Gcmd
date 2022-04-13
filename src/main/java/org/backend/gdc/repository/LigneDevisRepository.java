package org.backend.gdc.repository;

import org.backend.gdc.entity.LigneDevisEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneDevisRepository extends JpaRepository<LigneDevisEntity, Long> {
}