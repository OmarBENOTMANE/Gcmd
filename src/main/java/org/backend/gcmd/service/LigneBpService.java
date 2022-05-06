package org.backend.gcmd.service;

import org.backend.gcmd.dto.LigneBpDTO;
import org.backend.gcmd.entity.LigneBpEntity;
import org.backend.gcmd.exceptions.technical.ObjectNotFoundException;
import org.backend.gcmd.mapper.LigneBpMapper;
import org.backend.gcmd.repository.LigneBpRepository;
import org.backend.gcmd.validator.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class LigneBpService {

    @Autowired
    private LigneBpRepository ligneBpRepository;

    @Autowired
    private LigneBpMapper ligneBpMapper;

    public LigneBpDTO findById(Long id) {
        Validate.notNull(id, "id mus be not null");
        Optional<LigneBpEntity> entity = ligneBpRepository.findById(id);
        if (entity.isPresent()) {
            return ligneBpMapper.convertToDto(entity.get());
        } else {
            throw new ObjectNotFoundException("LigneBpDTO not found");
        }
    }

    public LigneBpDTO save(LigneBpDTO dto) {
        Validate.notNull(dto, "LigneBpDTO must be not null");
        LigneBpEntity entity = ligneBpMapper.convertToEntity(dto);
        LigneBpEntity saved = ligneBpRepository.save(entity);
        return ligneBpMapper.convertToDto(saved);
    }

    public LigneBpDTO update(LigneBpDTO dto) {
        Validate.notNull(dto, "LigneBpDTO must be not null");
        Validate.notNull(dto.getId(), "UserDTO id must be not null");
        findById(dto.getId());
        LigneBpEntity entity = ligneBpMapper.convertToEntity(dto);
        LigneBpEntity saved = ligneBpRepository.save(entity);
        return ligneBpMapper.convertToDto(saved);
    }

    public void delete(Long id) {
        Validate.notNull(id, "Id must be not null");
        findById(id);
        ligneBpRepository.deleteById(id);
    }

    public Page<LigneBpDTO> findAll(Pageable pageable) {
        Page<LigneBpEntity> page = ligneBpRepository.findAll(pageable);
        return ligneBpMapper.convertToPageDto(page);
    }

    public Page<LigneBpDTO> findAllByDeletedFalse(Pageable pageable) {
        Page<LigneBpEntity> page = ligneBpRepository.findAllByDeletedFalse(pageable);
        return ligneBpMapper.convertToPageDto(page);
    }
}
