package org.backend.gdc.mapper;

import org.backend.gdc.dto.MarchandiseDTO;
import org.backend.gdc.entity.MarchandiseEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MarchandiseMapper implements Mapper<MarchandiseDTO, MarchandiseEntity> {

    @Override
    public Page<MarchandiseDTO> convertToPageDto(Page<MarchandiseEntity> page) {
        return page.map(this::convertToDto);
    }

    @Override
    public MarchandiseDTO convertToDto(MarchandiseEntity entity) {
        MarchandiseDTO dto = new MarchandiseDTO();
        dto.setId(entity.getId());
        return dto;
    }

    @Override
    public MarchandiseEntity convertToEntity(MarchandiseDTO dto) {
        MarchandiseEntity entity = new MarchandiseEntity();
        entity.setId(dto.getId());
        return entity;
    }

    @Override
    public List<MarchandiseDTO> convertToDtoList(List<MarchandiseEntity> entities) {
        return entities.stream().map(this::convertToDto).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public List<MarchandiseEntity> convertToEntitiesList(List<MarchandiseDTO> dtos) {
        return dtos.stream().map(this::convertToEntity).collect(Collectors.toCollection(ArrayList::new));
    }
}
