package org.backend.gdc.mapper;

import org.backend.gdc.dto.NavireDTO;
import org.backend.gdc.entity.NavireEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class NavireMapper implements Mapper<NavireDTO,NavireEntity>{

    @Override
    public Page<NavireDTO> convertToPageDto(Page<NavireEntity> page) {
           return page.map(this::convertToDto);
    }

    @Override
    public NavireDTO convertToDto(NavireEntity entity) {
        NavireDTO dto= new NavireDTO();
        dto.setId(entity.getId());
        return dto;
    }

    @Override
    public NavireEntity convertToEntity(NavireDTO dto) {
        NavireEntity entity = new NavireEntity();
        entity.setId(dto.getId());
        return entity;
    }

    @Override
	public List<NavireDTO> convertToDtoList(List<NavireEntity> entities) {
		return entities.stream().map(this::convertToDto).collect(Collectors.toCollection(ArrayList::new));
	}

	@Override
	public List<NavireEntity> convertToEntitiesList(List<NavireDTO> dtos) {
		return dtos.stream().map(this::convertToEntity).collect(Collectors.toCollection(ArrayList::new));
	}
}
