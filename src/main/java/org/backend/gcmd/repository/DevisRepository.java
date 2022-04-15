package org.backend.gcmd.repository;

import org.backend.gcmd.entity.DevisEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevisRepository extends JpaRepository<DevisEntity, Long> {
}