package org.backend.gdc.service;

import org.backend.gdc.dto.TarifDTO;
import org.backend.gdc.entity.TarifEntity;
import org.backend.gdc.exceptions.technical.ObjectNotFoundException;
import org.backend.gdc.mapper.TarifMapper;
import org.backend.gdc.repository.TarifRepository;
import org.backend.gdc.validator.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class TarifService {

	@Autowired
	private TarifRepository tarifRepository;

	@Autowired
	private TarifMapper tarifMapper;

	public TarifDTO findById(Long id) {
		Validate.notNull(id, "id mus be not null");
		Optional<TarifEntity> entity = tarifRepository.findById(id);
		if (entity.isPresent()) {
			return tarifMapper.convertToDto(entity.get());
		} else {
			throw new ObjectNotFoundException("TarifDTO not found");
		}
	}

	public TarifDTO save(TarifDTO dto) {
		Validate.notNull(dto, "TarifDTO must be not null");
		TarifEntity entity = tarifMapper.convertToEntity(dto);

		TarifEntity saved = tarifRepository.save(entity);
		return tarifMapper.convertToDto(saved);
	}

	public TarifDTO update(TarifDTO dto) {
		Validate.notNull(dto, "TarifDTO must be not null");
		Validate.notNull(dto.getId(), "TarifDTO id must be not null");
		findById(dto.getId());
		TarifEntity entity = tarifMapper.convertToEntity(dto);
		TarifEntity saved = tarifRepository.save(entity);
		return tarifMapper.convertToDto(saved);

	}

	public void delete(Long id) {
		Validate.notNull(id, "Id must be not null");
		findById(id);
		tarifRepository.deleteById(id);
	}

	public Page<TarifDTO> findAll(Pageable pageable) {
		Page<TarifEntity> page = tarifRepository.findAll(pageable);
		return tarifMapper.convertToPageDto(page);

	}
}