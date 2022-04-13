package org.backend.gdc.service;

import org.backend.gdc.dto.EscaleDTO;
import org.backend.gdc.entity.EscaleEntity;
import org.backend.gdc.exceptions.technical.ObjectNotFoundException;
import org.backend.gdc.mapper.EscaleMapper;
import org.backend.gdc.repository.EscaleRepository;
import org.backend.gdc.validator.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class EscaleService {

	@Autowired
	private EscaleRepository escaleRepository;

	@Autowired
	private EscaleMapper escaleMapper;

	public EscaleDTO findById(Long id) {
		Validate.notNull(id, "id mus be not null");
		Optional<EscaleEntity> entity = escaleRepository.findById(id);
		if (entity.isPresent()) {
			return escaleMapper.convertToDto(entity.get());
		} else {
			throw new ObjectNotFoundException("EscaleDTO not found");
		}
	}

	public EscaleDTO save(EscaleDTO dto) {
		Validate.notNull(dto, "EscaleDTO must be not null");
		EscaleEntity entity = escaleMapper.convertToEntity(dto);

		EscaleEntity saved = escaleRepository.save(entity);
		return escaleMapper.convertToDto(saved);
	}

	public EscaleDTO update(EscaleDTO dto) {
		Validate.notNull(dto, "EscaleDTO must be not null");
		Validate.notNull(dto.getId(), "UserDTO id must be not null");
		findById(dto.getId());
		EscaleEntity entity = escaleMapper.convertToEntity(dto);
		EscaleEntity saved = escaleRepository.save(entity);
		return escaleMapper.convertToDto(saved);

	}

	public void delete(Long id) {
		Validate.notNull(id, "Id must be not null");
		findById(id);
		escaleRepository.deleteById(id);
	}

	public Page<EscaleDTO> findAll(Pageable pageable) {
		Page<EscaleEntity> page = escaleRepository.findAll(pageable);
		return escaleMapper.convertToPageDto(page);

	}
}
