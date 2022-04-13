package org.backend.gdc.mapper;

import org.backend.gdc.dto.LigneCommandeDTO;
import org.backend.gdc.entity.LigneCommandeEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LigneCommandeMapper implements Mapper<LigneCommandeDTO,LigneCommandeEntity>{

    @Override
    public Page<LigneCommandeDTO> convertToPageDto(Page<LigneCommandeEntity> page) {
           return page.map(this::convertToDto);
    }

    @Override
    public LigneCommandeDTO convertToDto(LigneCommandeEntity entity) {
        LigneCommandeDTO dto= new LigneCommandeDTO();
        dto.setId(entity.getId());
        return dto;
    }

    @Override
    public LigneCommandeEntity convertToEntity(LigneCommandeDTO dto) {
        LigneCommandeEntity entity = new LigneCommandeEntity();
        entity.setId(dto.getId());
        return entity;
    }

    @Override
	public List<LigneCommandeDTO> convertToDtoList(List<LigneCommandeEntity> entities) {
		return entities.stream().map(this::convertToDto).collect(Collectors.toCollection(ArrayList::new));
	}

	@Override
	public List<LigneCommandeEntity> convertToEntitiesList(List<LigneCommandeDTO> dtos) {
		return dtos.stream().map(this::convertToEntity).collect(Collectors.toCollection(ArrayList::new));
	}
}
