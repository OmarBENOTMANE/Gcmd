package org.backend.gcmd.service;

import org.backend.gcmd.mapper.LigneCommandeMapper;
import org.backend.gcmd.dto.LigneCommandeDTO;
import org.backend.gcmd.entity.LigneCommandeEntity;
import org.backend.gcmd.exceptions.technical.ObjectNotFoundException;
import org.backend.gcmd.repository.LigneCommandeRepository;
import org.backend.gcmd.validator.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class LigneCommandeService {

    @Autowired
    private LigneCommandeRepository ligneCommandeRepository;

    @Autowired
    private LigneCommandeMapper ligneCommandeMapper;

    public LigneCommandeDTO findById(Long id) {
        Validate.notNull(id, "id mus be not null");
        Optional<LigneCommandeEntity> entity = ligneCommandeRepository.findById(id);
        if (entity.isPresent()) {
            return ligneCommandeMapper.convertToDto(entity.get());
        } else {
            throw new ObjectNotFoundException("LigneCommandeDTO not found");
        }
    }

    public LigneCommandeDTO save(LigneCommandeDTO dto) {
        Validate.notNull(dto, "LigneCommandeDTO must be not null");
        LigneCommandeEntity entity = ligneCommandeMapper.convertToEntity(dto);

        LigneCommandeEntity saved = ligneCommandeRepository.save(entity);
        return ligneCommandeMapper.convertToDto(saved);
    }

    public LigneCommandeDTO update(LigneCommandeDTO dto) {
        Validate.notNull(dto, "LigneCommandeDTO must be not null");
        Validate.notNull(dto.getId(), "UserDTO id must be not null");
        findById(dto.getId());
        LigneCommandeEntity entity = ligneCommandeMapper.convertToEntity(dto);
        LigneCommandeEntity saved = ligneCommandeRepository.save(entity);
        return ligneCommandeMapper.convertToDto(saved);
    }

    public void delete(Long id) {
        Validate.notNull(id, "Id must be not null");
        findById(id);
        ligneCommandeRepository.deleteById(id);
    }

    public Page<LigneCommandeDTO> findAll(Pageable pageable) {
        Page<LigneCommandeEntity> page = ligneCommandeRepository.findAll(pageable);
        return ligneCommandeMapper.convertToPageDto(page);
    }
}
