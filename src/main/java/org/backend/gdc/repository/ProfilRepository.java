package org.backend.gdc.repository;

import org.backend.gdc.entity.ProfilEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfilRepository extends JpaRepository<ProfilEntity, Long> {
}