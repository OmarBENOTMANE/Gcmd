package org.backend.gcmd.service;

import org.backend.gcmd.dto.SousTypePrestationDTO;
import org.backend.gcmd.entity.SousTypePrestationEntity;
import org.backend.gcmd.exceptions.technical.ObjectNotFoundException;
import org.backend.gcmd.mapper.SousTypePrestationMapper;
import org.backend.gcmd.repository.SousTypePrestationRepository;
import org.backend.gcmd.validator.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class SousTypePrestationService {

    @Autowired
    private SousTypePrestationRepository sousTypePrestationRepository;

    @Autowired
    private SousTypePrestationMapper sousTypePrestationMapper;

    public SousTypePrestationDTO findById(Long id) {
        Validate.notNull(id, "id must be not null");
        Optional<SousTypePrestationEntity> entity = sousTypePrestationRepository.findById(id);
        if (entity.isPresent()) {
            return sousTypePrestationMapper.convertToDto(entity.get());
        } else {
            throw new ObjectNotFoundException("SousTypePrestationDTO not found");
        }
    }

    public SousTypePrestationDTO save(SousTypePrestationDTO dto) {
        Validate.notNull(dto, "SousTypePrestationDTO must be not null");
        SousTypePrestationEntity entity = sousTypePrestationMapper.convertToEntity(dto);
        SousTypePrestationEntity saved = sousTypePrestationRepository.save(entity);
        return sousTypePrestationMapper.convertToDto(saved);
    }

    public SousTypePrestationDTO update(SousTypePrestationDTO dto) {
        Validate.notNull(dto, "SousTypePrestationDTO must be not null");
        Validate.notNull(dto.getId(), "SousTypePrestationDTO id must be not null");
        findById(dto.getId());
        SousTypePrestationEntity entity = sousTypePrestationMapper.convertToEntity(dto);
        SousTypePrestationEntity saved = sousTypePrestationRepository.save(entity);
        return sousTypePrestationMapper.convertToDto(saved);

    }



    public Page<SousTypePrestationDTO> findAllByDeletedFalse(Pageable pageable) {
        Page<SousTypePrestationEntity> page = sousTypePrestationRepository.findAllByDeletedFalse(pageable);
        return sousTypePrestationMapper.convertToPageDto(page);

    }
}
