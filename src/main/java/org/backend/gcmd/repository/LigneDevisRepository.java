package org.backend.gcmd.repository;

import org.backend.gcmd.entity.LigneDevisEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneDevisRepository extends JpaRepository<LigneDevisEntity, Long> {
}