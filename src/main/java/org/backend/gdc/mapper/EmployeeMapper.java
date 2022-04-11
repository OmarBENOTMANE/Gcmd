package org.backend.gdc.model.mapper;

import org.backend.gdc.dto.EmployeeDTO;
import org.backend.gdc.entity.EmployeeEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeMapper implements Mapper<EmployeeDTO, EmployeeEntity> {

    @Override
    public Page<EmployeeDTO> convertToPageDto(Page<EmployeeEntity> page) {
        return page.map(this::convertToDto);
    }

    @Override
    public EmployeeDTO convertToDto(EmployeeEntity entity) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(entity.getId());
        dto.setNom(entity.getNom());
        dto.setPrenom(entity.getPrenom());
        return dto;
    }

    @Override
    public EmployeeEntity convertToEntity(EmployeeDTO dto) {
        EmployeeEntity entity = new EmployeeEntity();
        entity.setId(dto.getId());
        entity.setNom(dto.getNom());
        entity.setPrenom(dto.getPrenom());
        return entity;
    }

    @Override
    public List<EmployeeDTO> convertToDtoList(List<EmployeeEntity> entities) {
        return entities.stream().map(this::convertToDto).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public List<EmployeeEntity> convertToEntitiesList(List<EmployeeDTO> dtos) {
        return dtos.stream().map(this::convertToEntity).collect(Collectors.toCollection(ArrayList::new));
    }
}
