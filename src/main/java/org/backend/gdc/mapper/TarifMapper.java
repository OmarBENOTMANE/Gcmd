package org.backend.gdc.mapper;

import org.backend.gdc.dto.TarifDTO;
import org.backend.gdc.entity.TarifEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TarifMapper implements Mapper<TarifDTO, TarifEntity> {

    @Override
    public Page<TarifDTO> convertToPageDto(Page<TarifEntity> page) {
        return page.map(this::convertToDto);
    }

    @Override
    public TarifDTO convertToDto(TarifEntity entity) {
        TarifDTO dto = new TarifDTO();
        dto.setId(entity.getId());
        return dto;
    }

    @Override
    public TarifEntity convertToEntity(TarifDTO dto) {
        TarifEntity entity = new TarifEntity();
        entity.setId(dto.getId());
        return entity;
    }

    @Override
    public List<TarifDTO> convertToDtoList(List<TarifEntity> entities) {
        return entities.stream().map(this::convertToDto).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public List<TarifEntity> convertToEntitiesList(List<TarifDTO> dtos) {
        return dtos.stream().map(this::convertToEntity).collect(Collectors.toCollection(ArrayList::new));
    }
}