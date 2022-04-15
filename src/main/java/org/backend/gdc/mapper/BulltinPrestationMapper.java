package org.backend.gdc.mapper;

import org.backend.gdc.dto.BulltinPrestationDTO;
import org.backend.gdc.entity.BulltinPrestationEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BulltinPrestationMapper implements Mapper<BulltinPrestationDTO, BulltinPrestationEntity> {

    @Override
    public Page<BulltinPrestationDTO> convertToPageDto(Page<BulltinPrestationEntity> page) {
        return page.map(this::convertToDto);
    }

    @Override
    public BulltinPrestationDTO convertToDto(BulltinPrestationEntity entity) {
        BulltinPrestationDTO dto = new BulltinPrestationDTO();
        dto.setId(entity.getId());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    @Override
    public BulltinPrestationEntity convertToEntity(BulltinPrestationDTO dto) {
        BulltinPrestationEntity entity = new BulltinPrestationEntity();
        entity.setId(dto.getId());
        entity.setDescription(dto.getDescription());
        return entity;
    }

    @Override
    public List<BulltinPrestationDTO> convertToDtoList(List<BulltinPrestationEntity> entities) {
        return entities.stream().map(this::convertToDto).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public List<BulltinPrestationEntity> convertToEntitiesList(List<BulltinPrestationDTO> dtos) {
        return dtos.stream().map(this::convertToEntity).collect(Collectors.toCollection(ArrayList::new));
    }
}
