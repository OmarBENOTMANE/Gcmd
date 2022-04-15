package org.backend.gcmd.repository;

import org.backend.gcmd.entity.ProfilEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfilRepository extends JpaRepository<ProfilEntity, Long> {
}