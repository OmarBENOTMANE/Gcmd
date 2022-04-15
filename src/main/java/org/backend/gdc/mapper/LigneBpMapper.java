package org.backend.gdc.mapper;

import org.backend.gdc.dto.LigneBpDTO;
import org.backend.gdc.entity.LigneBpEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LigneBpMapper implements Mapper<LigneBpDTO, LigneBpEntity> {

    @Override
    public Page<LigneBpDTO> convertToPageDto(Page<LigneBpEntity> page) {
        return page.map(this::convertToDto);
    }

    @Override
    public LigneBpDTO convertToDto(LigneBpEntity entity) {
        LigneBpDTO dto = new LigneBpDTO();
        dto.setId(entity.getId());
        return dto;
    }

    @Override
    public LigneBpEntity convertToEntity(LigneBpDTO dto) {
        LigneBpEntity entity = new LigneBpEntity();
        entity.setId(dto.getId());
        return entity;
    }

    @Override
    public List<LigneBpDTO> convertToDtoList(List<LigneBpEntity> entities) {
        return entities.stream().map(this::convertToDto).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public List<LigneBpEntity> convertToEntitiesList(List<LigneBpDTO> dtos) {
        return dtos.stream().map(this::convertToEntity).collect(Collectors.toCollection(ArrayList::new));
    }
}
