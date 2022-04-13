package org.backend.gdc.repository;

import org.backend.gdc.entity.NavireEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NavireRepository extends JpaRepository<NavireEntity, Long> {
}