package org.backend.gdc.mapper;

import org.backend.gdc.dto.LigneDevisDTO;
import org.backend.gdc.entity.LigneDevisEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LigneDevisMapper implements Mapper<LigneDevisDTO, LigneDevisEntity> {

    @Override
    public Page<LigneDevisDTO> convertToPageDto(Page<LigneDevisEntity> page) {
        return page.map(this::convertToDto);
    }

    @Override
    public LigneDevisDTO convertToDto(LigneDevisEntity entity) {
        LigneDevisDTO dto = new LigneDevisDTO();
        dto.setId(entity.getId());
        return dto;
    }

    @Override
    public LigneDevisEntity convertToEntity(LigneDevisDTO dto) {
        LigneDevisEntity entity = new LigneDevisEntity();
        entity.setId(dto.getId());
        return entity;
    }

    @Override
    public List<LigneDevisDTO> convertToDtoList(List<LigneDevisEntity> entities) {
        return entities.stream().map(this::convertToDto).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public List<LigneDevisEntity> convertToEntitiesList(List<LigneDevisDTO> dtos) {
        return dtos.stream().map(this::convertToEntity).collect(Collectors.toCollection(ArrayList::new));
    }
}
