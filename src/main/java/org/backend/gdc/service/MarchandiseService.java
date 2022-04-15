package org.backend.gdc.service;

import org.backend.gdc.dto.MarchandiseDTO;
import org.backend.gdc.entity.MarchandiseEntity;
import org.backend.gdc.exceptions.technical.ObjectNotFoundException;
import org.backend.gdc.mapper.MarchandiseMapper;
import org.backend.gdc.repository.MarchandiseRepository;
import org.backend.gdc.validator.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class MarchandiseService {

    @Autowired
    private MarchandiseRepository marchandiseRepository;

    @Autowired
    private MarchandiseMapper marchandiseMapper;

    public MarchandiseDTO findById(Long id) {
        Validate.notNull(id, "id mus be not null");
        Optional<MarchandiseEntity> entity = marchandiseRepository.findById(id);
        if (entity.isPresent()) {
            return marchandiseMapper.convertToDto(entity.get());
        } else {
            throw new ObjectNotFoundException("MarchandiseDTO not found");
        }
    }

    public MarchandiseDTO save(MarchandiseDTO dto) {
        Validate.notNull(dto, "MarchandiseDTO must be not null");
        MarchandiseEntity entity = marchandiseMapper.convertToEntity(dto);

        MarchandiseEntity saved = marchandiseRepository.save(entity);
        return marchandiseMapper.convertToDto(saved);
    }

    public MarchandiseDTO update(MarchandiseDTO dto) {
        Validate.notNull(dto, "MarchandiseDTO must be not null");
        Validate.notNull(dto.getId(), "UserDTO id must be not null");
        findById(dto.getId());
        MarchandiseEntity entity = marchandiseMapper.convertToEntity(dto);
        MarchandiseEntity saved = marchandiseRepository.save(entity);
        return marchandiseMapper.convertToDto(saved);

    }

    public void delete(Long id) {
        Validate.notNull(id, "Id must be not null");
        findById(id);
        marchandiseRepository.deleteById(id);
    }

    public Page<MarchandiseDTO> findAll(Pageable pageable) {
        Page<MarchandiseEntity> page = marchandiseRepository.findAll(pageable);
        return marchandiseMapper.convertToPageDto(page);

    }
}
