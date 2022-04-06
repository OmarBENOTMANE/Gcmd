package org.backend.gdc.repository;

import org.backend.gdc.entity.EmployeeEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<EmployeeEntity, Long> {


}
