package org.backend.gcmd.mapper;

import org.backend.gcmd.dto.LigneDevisDTO;
import org.backend.gcmd.entity.LigneDevisEntity;
import org.backend.gcmd.repository.DevisRepository;
import org.backend.gcmd.repository.PrestationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LigneDevisMapper implements Mapper<LigneDevisDTO, LigneDevisEntity> {

    @Autowired
    DevisRepository devisRepository;

    @Autowired
    PrestationRepository prestationRepository;

    @Override
    public Page<LigneDevisDTO> convertToPageDto(Page<LigneDevisEntity> page) {
        return page.map(this::convertToDto);
    }

    @Override
    public LigneDevisDTO convertToDto(LigneDevisEntity entity) {
        LigneDevisDTO dto = new LigneDevisDTO();
        dto.setId(entity.getId());
        dto.setId(entity.getId());
        dto.setDesignation(entity.getDesignation());
        dto.setNombreUnite(entity.getNombreUnite());
        dto.setQuantite(entity.getQuantite());
        dto.setTotal(entity.getTotal());
        dto.setDevisId(entity.getDevisId());
        dto.setPrestationId(entity.getPrestationId());
        return dto;
    }

    @Override
    public LigneDevisEntity convertToEntity(LigneDevisDTO dto) {
        LigneDevisEntity entity = new LigneDevisEntity();
        entity.setId(dto.getId());
        entity.setDesignation(dto.getDesignation());
        entity.setNombreUnite(dto.getNombreUnite());
        entity.setQuantite(dto.getQuantite());
        entity.setTotal(dto.getTotal());
        entity.setDevisId(dto.getDevisId());
        entity.setPrestationId(dto.getPrestationId());

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
