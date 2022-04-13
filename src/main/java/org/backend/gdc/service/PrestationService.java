package org.backend.gdc.service;

import org.backend.gdc.dto.PrestationDTO;
import org.backend.gdc.entity.PrestationEntity;
import org.backend.gdc.exceptions.technical.ObjectNotFoundException;
import org.backend.gdc.mapper.PrestationMapper;
import org.backend.gdc.repository.PrestationRepository;
import org.backend.gdc.validator.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class PrestationService {

	@Autowired
	private PrestationRepository prestationRepository;

	@Autowired
	private PrestationMapper prestationMapper;

	public PrestationDTO findById(Long id) {
		Validate.notNull(id, "id mus be not null");
		Optional<PrestationEntity> entity = prestationRepository.findById(id);
		if (entity.isPresent()) {
			return prestationMapper.convertToDto(entity.get());
		} else {
			throw new ObjectNotFoundException("PrestationDTO not found");
		}
	}

	public PrestationDTO save(PrestationDTO dto) {
		Validate.notNull(dto, "PrestationDTO must be not null");
		PrestationEntity entity = prestationMapper.convertToEntity(dto);

		PrestationEntity saved = prestationRepository.save(entity);
		return prestationMapper.convertToDto(saved);
	}

	public PrestationDTO update(PrestationDTO dto) {
		Validate.notNull(dto, "PrestationDTO must be not null");
		Validate.notNull(dto.getId(), "PrestationDTO id must be not null");
		findById(dto.getId());
		PrestationEntity entity = prestationMapper.convertToEntity(dto);
		PrestationEntity saved = prestationRepository.save(entity);
		return prestationMapper.convertToDto(saved);

	}

	public void delete(Long id) {
		Validate.notNull(id, "Id must be not null");
		findById(id);
		prestationRepository.deleteById(id);
	}

	public Page<PrestationDTO> findAll(Pageable pageable) {
		Page<PrestationEntity> page = prestationRepository.findAll(pageable);
		return prestationMapper.convertToPageDto(page);

	}
}