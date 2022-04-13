package org.backend.gdc.repository;

import org.backend.gdc.entity.DevisEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevisRepository extends JpaRepository<DevisEntity, Long> {
}