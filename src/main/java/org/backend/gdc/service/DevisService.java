package org.backend.gdc.service;

import org.backend.gdc.dto.DevisDTO;
import org.backend.gdc.entity.DevisEntity;
import org.backend.gdc.exceptions.technical.ObjectNotFoundException;
import org.backend.gdc.mapper.DevisMapper;
import org.backend.gdc.repository.DevisRepository;
import org.backend.gdc.validator.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class DevisService {

	@Autowired
	private DevisRepository devisRepository;

	@Autowired
	private DevisMapper devisMapper;

	public DevisDTO findById(Long id) {
		Validate.notNull(id, "id mus be not null");
		Optional<DevisEntity> entity = devisRepository.findById(id);
		if (entity.isPresent()) {
			return devisMapper.convertToDto(entity.get());
		} else {
			throw new ObjectNotFoundException("DevisDTO not found");
		}
	}

	public DevisDTO save(DevisDTO dto) {
		Validate.notNull(dto, "DevisDTO must be not null");
		DevisEntity entity = devisMapper.convertToEntity(dto);

		DevisEntity saved = devisRepository.save(entity);
		return devisMapper.convertToDto(saved);
	}

	public DevisDTO update(DevisDTO dto) {
		Validate.notNull(dto, "DevisDTO must be not null");
		Validate.notNull(dto.getId(), "UserDTO id must be not null");
		findById(dto.getId());
		DevisEntity entity = devisMapper.convertToEntity(dto);
		DevisEntity saved = devisRepository.save(entity);
		return devisMapper.convertToDto(saved);

	}

	public void delete(Long id) {
		Validate.notNull(id, "Id must be not null");
		findById(id);
		devisRepository.deleteById(id);
	}

	public Page<DevisDTO> findAll(Pageable pageable) {
		Page<DevisEntity> page = devisRepository.findAll(pageable);
		return devisMapper.convertToPageDto(page);

	}
}
