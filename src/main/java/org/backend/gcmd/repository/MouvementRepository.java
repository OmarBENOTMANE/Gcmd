package org.backend.gcmd.repository;

import org.backend.gcmd.entity.MouvementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MouvementRepository extends JpaRepository<MouvementEntity, Long> {
}