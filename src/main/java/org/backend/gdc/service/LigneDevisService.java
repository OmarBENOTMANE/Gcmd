package org.backend.gdc.service;

import org.backend.gdc.dto.LigneDevisDTO;
import org.backend.gdc.entity.LigneDevisEntity;
import org.backend.gdc.exceptions.technical.ObjectNotFoundException;
import org.backend.gdc.mapper.LigneDevisMapper;
import org.backend.gdc.repository.LigneDevisRepository;
import org.backend.gdc.validator.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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

	public void delete(Long id) {
		Validate.notNull(id, "Id must be not null");
		findById(id);
		ligneDevisRepository.deleteById(id);
	}

	public Page<LigneDevisDTO> findAll(Pageable pageable) {
		Page<LigneDevisEntity> page = ligneDevisRepository.findAll(pageable);
		return ligneDevisMapper.convertToPageDto(page);

	}
}
