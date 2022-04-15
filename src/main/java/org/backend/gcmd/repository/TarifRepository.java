package org.backend.gcmd.repository;

import org.backend.gcmd.entity.TarifEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarifRepository extends JpaRepository<TarifEntity, Long> {
}