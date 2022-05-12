package org.backend.gcmd.service;

import java.util.Optional;

import org.backend.gcmd.dto.CommandeDTO;
import org.backend.gcmd.entity.CommandeEntity;
import org.backend.gcmd.exceptions.technical.ObjectNotFoundException;
import org.backend.gcmd.mapper.CommandeMapper;
import org.backend.gcmd.repository.CommandeRepository;
import org.backend.gcmd.validator.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		Validate.notNull(dto.getId(), "CommandeDTO id must be not null");
		findById(dto.getId());
		CommandeEntity entity = commandeMapper.convertToEntity(dto);
		CommandeEntity saved = commandeRepository.save(entity);
		return commandeMapper.convertToDto(saved);
	}

	public Page<CommandeDTO> findAllByDeletedFalse(Pageable pageable) {
		Page<CommandeEntity> page = commandeRepository.findAllByDeletedFalse(pageable);
		return commandeMapper.convertToPageDto(page);
	}
}
