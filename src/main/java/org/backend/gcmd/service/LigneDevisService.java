package org.backend.gcmd.service;

import java.util.Optional;

import org.backend.gcmd.dto.LigneDevisDTO;
import org.backend.gcmd.entity.LigneDevisEntity;
import org.backend.gcmd.exceptions.technical.ObjectNotFoundException;
import org.backend.gcmd.mapper.LigneDevisMapper;
import org.backend.gcmd.repository.LigneDevisRepository;
import org.backend.gcmd.validator.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LigneDevisService {

	@Autowired
	private LigneDevisRepository ligneDevisRepository;

	@Autowired
	private LigneDevisMapper ligneDevisMapper;

	public LigneDevisDTO findById(Long id) {
		Validate.notNull(id, "id mus be not null");
		Optional<LigneDevisEntity> entity = ligneDevisRepository.findById(id);
		if (entity.isPresent()) {
			return ligneDevisMapper.convertToDto(entity.get());
		} else {
			throw new ObjectNotFoundException("LigneDevisDTO not found");
		}
	}

	public LigneDevisDTO save(LigneDevisDTO dto) {
		Validate.notNull(dto, "LigneDevisDTO must be not null");
		LigneDevisEntity entity = ligneDevisMapper.convertToEntity(dto);
		LigneDevisEntity saved = ligneDevisRepository.save(entity);
		return ligneDevisMapper.convertToDto(saved);
	}

	public LigneDevisDTO update(LigneDevisDTO dto) {
		Validate.notNull(dto, "LigneDevisDTO must be not null");
		Validate.notNull(dto.getId(), "UserDTO id must be not null");
		findById(dto.getId());
		LigneDevisEntity entity = ligneDevisMapper.convertToEntity(dto);
		LigneDevisEntity saved = ligneDevisRepository.save(entity);
		return ligneDevisMapper.convertToDto(saved);
	}

	public Page<LigneDevisDTO> findAllByDeletedFalse(Pageable pageable) {
		Page<LigneDevisEntity> page = ligneDevisRepository.findAllByDeletedFalse(pageable);
		return ligneDevisMapper.convertToPageDto(page);
	}
}
