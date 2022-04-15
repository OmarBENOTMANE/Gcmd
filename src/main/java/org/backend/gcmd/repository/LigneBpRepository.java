package org.backend.gcmd.repository;

import org.backend.gcmd.entity.LigneBpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneBpRepository extends JpaRepository<LigneBpEntity, Long> {
}