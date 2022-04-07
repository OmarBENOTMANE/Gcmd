package org.backend.gdc.service;

import org.backend.gdc.dto.EmployeeDTO;
import org.backend.gdc.model.entity.EmployeeEntity;
import org.backend.gdc.exceptions.technical.ObjectNotFoundException;
import org.backend.gdc.model.mapper.EmployeeMapper;
import org.backend.gdc.repository.EmployeeRepository;
import org.backend.gdc.validator.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    public EmployeeDTO findById(Long id) {
        Validate.notNull(id, "id mus be not null");
        Optional<EmployeeEntity> entity = employeeRepository.findById(id);

        if (entity.isPresent()) {
            return employeeMapper.convertToDto(entity.get());
        } else {
            throw new ObjectNotFoundException("EmployeeDTO not found");
        }
    }

    public EmployeeDTO save(EmployeeDTO dto) {
        Validate.notNull(dto, "EmployeeDTO must be not null");
        EmployeeEntity entity = employeeMapper.convertToEntity(dto);
        EmployeeEntity saved = employeeRepository.save(entity);
        return employeeMapper.convertToDto(saved);

    }

    public EmployeeDTO update(EmployeeDTO dto) {
        Validate.notNull(dto, "EmployeeDTO must be not null");
        Validate.notNull(dto.getId(), "UserDTO id must be not null");
        findById(dto.getId());
        EmployeeEntity entity = employeeMapper.convertToEntity(dto);
        EmployeeEntity saved = employeeRepository.save(entity);
        return employeeMapper.convertToDto(saved);

    }

    public void delete(Long id) {
        Validate.notNull(id, "Id must be not null");
        findById(id);
        employeeRepository.deleteById(id);
    }

    public Page<EmployeeDTO> findAll(Pageable pageable) {
        Page<EmployeeEntity> page = employeeRepository.findAll(pageable);
        return employeeMapper.convertToPageDto(page);

    }
}
