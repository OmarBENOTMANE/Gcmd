package org.backend.gcmd.service;

import org.backend.gcmd.dto.BulltinPrestationDTO;
import org.backend.gcmd.entity.BulltinPrestationEntity;
import org.backend.gcmd.exceptions.technical.ObjectNotFoundException;
import org.backend.gcmd.mapper.BulltinPrestationMapper;
import org.backend.gcmd.repository.BulltinPrestationRepository;
import org.backend.gcmd.validator.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class BulltinPrestationService {

    @Autowired
    private BulltinPrestationRepository bulltinPrestationRepository;

    @Autowired
    private BulltinPrestationMapper bulltinPrestationMapper;


    public BulltinPrestationDTO findById(Long id) {
        Validate.notNull(id, "id mus be not null");
        Optional<BulltinPrestationEntity> entity = bulltinPrestationRepository.findById(id);
        if (entity.isPresent()) {
            return bulltinPrestationMapper.convertToDto(entity.get());
        } else {
            throw new ObjectNotFoundException("BulltinPrestationDTO not found");
        }
    }

    public BulltinPrestationDTO save(BulltinPrestationDTO dto) {
        Validate.notNull(dto, "BulltinPrestationDTO must be not null");
        BulltinPrestationEntity entity = bulltinPrestationMapper.convertToEntity(dto);
        BulltinPrestationEntity saved = bulltinPrestationRepository.save(entity);
        return bulltinPrestationMapper.convertToDto(saved);
    }

    public BulltinPrestationDTO update(BulltinPrestationDTO dto) {
        Validate.notNull(dto, "BulltinPrestationDTO must be not null");
        Validate.notNull(dto.getId(), "BulltinPrestationDTO id must be not null");
        findById(dto.getId());
        BulltinPrestationEntity entity = bulltinPrestationMapper.convertToEntity(dto);
        BulltinPrestationEntity saved = bulltinPrestationRepository.save(entity);
        return bulltinPrestationMapper.convertToDto(saved);

    }

//    public void delete(Long id) {
//        Validate.notNull(id, "Id must be not null");
//        findById(id);
//        bulltinPrestationRepository.deleteById(id);
//    }

    public Page<BulltinPrestationDTO> findAll(Pageable pageable) {
        Page<BulltinPrestationEntity> page = bulltinPrestationRepository.findAll(pageable);
        return bulltinPrestationMapper.convertToPageDto(page);
    }

    public Page<BulltinPrestationDTO> findAllByDeletedFalse(Pageable pageable) {
        Page<BulltinPrestationEntity> page = bulltinPrestationRepository.findAllByDeletedFalse(pageable);
        return bulltinPrestationMapper.convertToPageDto(page);
    }

}
