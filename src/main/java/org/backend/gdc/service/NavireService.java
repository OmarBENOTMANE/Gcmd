package org.backend.gdc.service;

import org.backend.gdc.dto.NavireDTO;
import org.backend.gdc.entity.NavireEntity;
import org.backend.gdc.exceptions.technical.ObjectNotFoundException;
import org.backend.gdc.mapper.NavireMapper;
import org.backend.gdc.repository.NavireRepository;
import org.backend.gdc.validator.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class NavireService {

	@Autowired
	private NavireRepository navireRepository;

	@Autowired
	private NavireMapper navireMapper;

	public NavireDTO findById(Long id) {
		Validate.notNull(id, "id mus be not null");
		Optional<NavireEntity> entity = navireRepository.findById(id);
		if (entity.isPresent()) {
			return navireMapper.convertToDto(entity.get());
		} else {
			throw new ObjectNotFoundException("NavireDTO not found");
		}
	}

	public NavireDTO save(NavireDTO dto) {
		Validate.notNull(dto, "NavireDTO must be not null");
		NavireEntity entity = navireMapper.convertToEntity(dto);

		NavireEntity saved = navireRepository.save(entity);
		return navireMapper.convertToDto(saved);
	}

	public NavireDTO update(NavireDTO dto) {
		Validate.notNull(dto, "NavireDTO must be not null");
		Validate.notNull(dto.getId(), "DTO id must be not null");
		findById(dto.getId());
		NavireEntity entity = navireMapper.convertToEntity(dto);
		NavireEntity saved = navireRepository.save(entity);
		return navireMapper.convertToDto(saved);

	}

	public void delete(Long id) {
		Validate.notNull(id, "Id must be not null");
		findById(id);
		navireRepository.deleteById(id);
	}

	public Page<NavireDTO> findAll(Pageable pageable) {
		Page<NavireEntity> page = navireRepository.findAll(pageable);
		return navireMapper.convertToPageDto(page);

	}
}
