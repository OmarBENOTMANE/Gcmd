package org.backend.gcmd.service;

import org.backend.gcmd.dto.PermissionDTO;
import org.backend.gcmd.entity.PermissionEntity;
import org.backend.gcmd.exceptions.technical.ObjectNotFoundException;
import org.backend.gcmd.mapper.PermissionMapper;
import org.backend.gcmd.repository.PermissionRepository;
import org.backend.gcmd.validator.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private PermissionMapper permissionMapper;

    public PermissionDTO findById(Long id) {
        Validate.notNull(id, "id mus be not null");
        Optional<PermissionEntity> entity = permissionRepository.findById(id);
        if (entity.isPresent()) {
            return permissionMapper.convertToDto(entity.get());
        } else {
            throw new ObjectNotFoundException("PermissionDTO not found");
        }
    }

    public PermissionDTO save(PermissionDTO dto) {
        Validate.notNull(dto, "PermissionDTO must be not null");
        PermissionEntity entity = permissionMapper.convertToEntity(dto);

        PermissionEntity saved = permissionRepository.save(entity);
        return permissionMapper.convertToDto(saved);
    }

    public PermissionDTO update(PermissionDTO dto) {
        Validate.notNull(dto, "PermissionDTO must be not null");
        Validate.notNull(dto.getId(), "UserDTO id must be not null");
        findById(dto.getId());
        PermissionEntity entity = permissionMapper.convertToEntity(dto);
        PermissionEntity saved = permissionRepository.save(entity);
        return permissionMapper.convertToDto(saved);

    }

    public void delete(Long id) {
        Validate.notNull(id, "Id must be not null");
        findById(id);
        permissionRepository.deleteById(id);
    }

    public Page<PermissionDTO> findAll(Pageable pageable) {
        Page<PermissionEntity> page = permissionRepository.findAll(pageable);
        return permissionMapper.convertToPageDto(page);

    }
}
