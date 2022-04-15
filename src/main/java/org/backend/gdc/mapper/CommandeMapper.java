package org.backend.gdc.mapper;

import org.backend.gdc.dto.CommandeDTO;
import org.backend.gdc.entity.CommandeEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommandeMapper implements Mapper<CommandeDTO, CommandeEntity> {

    @Override
    public Page<CommandeDTO> convertToPageDto(Page<CommandeEntity> page) {
        return page.map(this::convertToDto);
    }

    @Override
    public CommandeDTO convertToDto(CommandeEntity entity) {
        CommandeDTO dto = new CommandeDTO();
        dto.setId(entity.getId());
        return dto;
    }

    @Override
    public CommandeEntity convertToEntity(CommandeDTO dto) {
        CommandeEntity entity = new CommandeEntity();
        entity.setId(dto.getId());
        return entity;
    }

    @Override
    public List<CommandeDTO> convertToDtoList(List<CommandeEntity> entities) {
        return entities.stream().map(this::convertToDto).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public List<CommandeEntity> convertToEntitiesList(List<CommandeDTO> dtos) {
        return dtos.stream().map(this::convertToEntity).collect(Collectors.toCollection(ArrayList::new));
    }
}
