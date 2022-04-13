package org.backend.gdc.service;

import org.backend.gdc.dto.CommandeDTO;
import org.backend.gdc.entity.CommandeEntity;
import org.backend.gdc.exceptions.technical.ObjectNotFoundException;
import org.backend.gdc.mapper.CommandeMapper;
import org.backend.gdc.repository.CommandeRepository;
import org.backend.gdc.validator.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CommandeService {

	@Autowired
	private CommandeRepository commandeRepository;

	@Autowired
	private CommandeMapper commandeMapper;

	public CommandeDTO findById(Long id) {
		Validate.notNull(id, "id mus be not null");
		Optional<CommandeEntity> entity = commandeRepository.findById(id);
		if (entity.isPresent()) {
			return commandeMapper.convertToDto(entity.get());
		} else {
			throw new ObjectNotFoundException("CommandeDTO not found");
		}
	}

	public CommandeDTO save(CommandeDTO dto) {
		Validate.notNull(dto, "CommandeDTO must be not null");
		CommandeEntity entity = commandeMapper.convertToEntity(dto);

		CommandeEntity saved = commandeRepository.save(entity);
		return commandeMapper.convertToDto(saved);
	}

	public CommandeDTO update(CommandeDTO dto) {
		Validate.notNull(dto, "CommandeDTO must be not null");
		Validate.notNull(dto.getId(), "UserDTO id must be not null");
		findById(dto.getId());
		CommandeEntity entity = commandeMapper.convertToEntity(dto);
		CommandeEntity saved = commandeRepository.save(entity);
		return commandeMapper.convertToDto(saved);

	}

	public void delete(Long id) {
		Validate.notNull(id, "Id must be not null");
		findById(id);
		commandeRepository.deleteById(id);
	}

	public Page<CommandeDTO> findAll(Pageable pageable) {
		Page<CommandeEntity> page = commandeRepository.findAll(pageable);
		return commandeMapper.convertToPageDto(page);

	}
}