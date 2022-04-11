package org.backend.gdc.repository;

import org.backend.gdc.entity.DevisEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DevisRepository extends JpaRepository<DevisEntity, Long> {
}