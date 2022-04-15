package org.backend.gdc.mapper;

import org.backend.gdc.dto.ClientDTO;
import org.backend.gdc.entity.ClientEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientMapper implements Mapper<ClientDTO, ClientEntity> {

    @Override
    public Page<ClientDTO> convertToPageDto(Page<ClientEntity> page) {
        return page.map(this::convertToDto);
    }

    @Override
    public ClientDTO convertToDto(ClientEntity entity) {
        ClientDTO dto = new ClientDTO();
        dto.setId(entity.getId());
        return dto;
    }

    @Override
    public ClientEntity convertToEntity(ClientDTO dto) {
        ClientEntity entity = new ClientEntity();
        entity.setId(dto.getId());
        return entity;
    }

    @Override
    public List<ClientDTO> convertToDtoList(List<ClientEntity> entities) {
        return entities.stream().map(this::convertToDto).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public List<ClientEntity> convertToEntitiesList(List<ClientDTO> dtos) {
        return dtos.stream().map(this::convertToEntity).collect(Collectors.toCollection(ArrayList::new));
    }
}
