package org.backend.gcmd.service;

import org.backend.gcmd.dto.TypePrestationDTO;
import org.backend.gcmd.entity.TypePrestationEntity;
import org.backend.gcmd.exceptions.technical.ObjectNotFoundException;
import org.backend.gcmd.mapper.TypePrestationMapper;
import org.backend.gcmd.repository.TypePrestationRepository;
import org.backend.gcmd.validator.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class TypePrestationService {

    @Autowired
    private TypePrestationRepository typePrestationRepository;

    @Autowired
    private TypePrestationMapper typePrestationMapper;

    public TypePrestationDTO findById(Long id) {
        Validate.notNull(id, "id mus be not null");
        Optional<TypePrestationEntity> entity = typePrestationRepository.findById(id);
        if (entity.isPresent()) {
            return typePrestationMapper.convertToDto(entity.get());
        } else {
            throw new ObjectNotFoundException("TypePrestationDTO not found");
        }
    }

    public TypePrestationDTO save(TypePrestationDTO dto) {
        Validate.notNull(dto, "TypePrestationDTO must be not null");
        TypePrestationEntity entity = typePrestationMapper.convertToEntity(dto);
        TypePrestationEntity saved = typePrestationRepository.save(entity);
        return typePrestationMapper.convertToDto(saved);
    }

    public TypePrestationDTO update(TypePrestationDTO dto) {
        Validate.notNull(dto, "TypePrestationDTO must be not null");
        Validate.notNull(dto.getId(), "TypePrestationDTO id must be not null");
        findById(dto.getId());
        TypePrestationEntity entity = typePrestationMapper.convertToEntity(dto);
        TypePrestationEntity saved = typePrestationRepository.save(entity);
        return typePrestationMapper.convertToDto(saved);
    }

//    public void delete(Long id) {
//        Validate.notNull(id, "Id must be not null");
//        findById(id);
//        typePrestationRepository.deleteById(id);
//    }

    public Page<TypePrestationDTO> findAll(Pageable pageable) {
        Page<TypePrestationEntity> page = typePrestationRepository.findAll(pageable);
        return typePrestationMapper.convertToPageDto(page);
    }

    public Page<TypePrestationDTO> findAllByDeletedFalse(Pageable pageable) {
        Page<TypePrestationEntity> page = typePrestationRepository.findAllByDeletedFalse(pageable);
        return typePrestationMapper.convertToPageDto(page);
    }

}
