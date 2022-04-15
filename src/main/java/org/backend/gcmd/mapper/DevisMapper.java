package org.backend.gcmd.mapper;

import org.backend.gcmd.dto.DevisDTO;
import org.backend.gcmd.entity.DevisEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DevisMapper implements Mapper<DevisDTO, DevisEntity> {

    @Override
    public Page<DevisDTO> convertToPageDto(Page<DevisEntity> page) {
        return page.map(this::convertToDto);
    }

    @Override
    public DevisDTO convertToDto(DevisEntity entity) {
        DevisDTO dto = new DevisDTO();
        dto.setId(entity.getId());
        return dto;
    }

    @Override
    public DevisEntity convertToEntity(DevisDTO dto) {
        DevisEntity entity = new DevisEntity();
        entity.setId(dto.getId());
        return entity;
    }

    @Override
    public List<DevisDTO> convertToDtoList(List<DevisEntity> entities) {
        return entities.stream().map(this::convertToDto).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public List<DevisEntity> convertToEntitiesList(List<DevisDTO> dtos) {
        return dtos.stream().map(this::convertToEntity).collect(Collectors.toCollection(ArrayList::new));
    }
}
