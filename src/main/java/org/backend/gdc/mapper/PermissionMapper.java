package org.backend.gdc.mapper;

import org.backend.gdc.dto.PermissionDTO;
import org.backend.gdc.entity.PermissionEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PermissionMapper implements Mapper<PermissionDTO,PermissionEntity>{

    @Override
    public Page<PermissionDTO> convertToPageDto(Page<PermissionEntity> page) {
           return page.map(this::convertToDto);
    }

    @Override
    public PermissionDTO convertToDto(PermissionEntity entity) {
        PermissionDTO dto= new PermissionDTO();
        dto.setId(entity.getId());
        return dto;
    }

    @Override
    public PermissionEntity convertToEntity(PermissionDTO dto) {
        PermissionEntity entity = new PermissionEntity();
        entity.setId(dto.getId());
        return entity;
    }

    @Override
	public List<PermissionDTO> convertToDtoList(List<PermissionEntity> entities) {
		return entities.stream().map(this::convertToDto).collect(Collectors.toCollection(ArrayList::new));
	}

	@Override
	public List<PermissionEntity> convertToEntitiesList(List<PermissionDTO> dtos) {
		return dtos.stream().map(this::convertToEntity).collect(Collectors.toCollection(ArrayList::new));
	}
}
