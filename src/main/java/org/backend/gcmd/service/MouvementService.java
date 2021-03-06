package org.backend.gcmd.service;

import org.backend.gcmd.dto.MouvementDTO;
import org.backend.gcmd.entity.MouvementEntity;
import org.backend.gcmd.exceptions.technical.ObjectNotFoundException;
import org.backend.gcmd.mapper.MouvementMapper;
import org.backend.gcmd.repository.MouvementRepository;
import org.backend.gcmd.validator.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class MouvementService {

    @Autowired
    private MouvementRepository mouvementRepository;

    @Autowired
    private MouvementMapper mouvementMapper;

    public MouvementDTO findById(Long id) {
        Validate.notNull(id, "id mus be not null");
        Optional<MouvementEntity> entity = mouvementRepository.findById(id);
        if (entity.isPresent()) {
            return mouvementMapper.convertToDto(entity.get());
        } else {
            throw new ObjectNotFoundException("MouvementDTO not found");
        }
    }

    public MouvementDTO save(MouvementDTO dto) {
        Validate.notNull(dto, "MouvementDTO must be not null");
        MouvementEntity entity = mouvementMapper.convertToEntity(dto);
        MouvementEntity saved = mouvementRepository.save(entity);
        return mouvementMapper.convertToDto(saved);
    }

    public MouvementDTO update(MouvementDTO dto) {
        Validate.notNull(dto, "MouvementDTO must be not null");
        Validate.notNull(dto.getId(), "MouvementDTO id must be not null");
        findById(dto.getId());
        MouvementEntity entity = mouvementMapper.convertToEntity(dto);
        MouvementEntity saved = mouvementRepository.save(entity);
        return mouvementMapper.convertToDto(saved);
    }





    public Page<MouvementDTO> findAllByDeletedFalse(Pageable pageable) {
        Page<MouvementEntity> page = mouvementRepository.findAllByDeletedFalse(pageable);
        return mouvementMapper.convertToPageDto(page);
    }
}
