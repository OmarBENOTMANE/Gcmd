package org.backend.gcmd.repository;

import org.backend.gcmd.entity.UniteOrganisationelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniteOrganisationelRepository extends JpaRepository<UniteOrganisationelEntity, Long> {
}