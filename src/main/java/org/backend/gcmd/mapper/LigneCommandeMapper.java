package org.backend.gcmd.mapper;

import org.backend.gcmd.dto.LigneCommandeDTO;
import org.backend.gcmd.entity.LigneCommandeEntity;
import org.backend.gcmd.repository.CommandeRepository;
import org.backend.gcmd.repository.LigneCommandeRepository;
import org.backend.gcmd.repository.PrestationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LigneCommandeMapper implements Mapper<LigneCommandeDTO, LigneCommandeEntity> {

    @Autowired
    PrestationRepository prestationRepository;

    @Autowired
    CommandeRepository commandeRepository;

    @Override
    public Page<LigneCommandeDTO> convertToPageDto(Page<LigneCommandeEntity> page) {
        return page.map(this::convertToDto);
    }

    @Override
    public LigneCommandeDTO convertToDto(LigneCommandeEntity entity) {
        LigneCommandeDTO dto = new LigneCommandeDTO();
        dto.setId(entity.getId());
        dto.setDate(entity.getDate());
        dto.setDescription(entity.getDescription());
        dto.setHeure(entity.getHeure());
        dto.setNombre(entity.getNombre());
        dto.setProduit(entity.getProduit());
        dto.setSensTrafic(entity.getSensTrafic());
        dto.setTarifUnifie(entity.getTarifUnifie());
        dto.setTcConv(entity.getTcConv());
        dto.setTcSuppl(entity.getTcSuppl());
        dto.setTonnageMinimum(entity.getTonnageMinimum());
        dto.setTonnageReel(entity.getTonnageReel());
        dto.setPrestationId(entity.getPrestationId());
        dto.setCommandeId(entity.getCommandeId());
        return dto;
    }

    @Override
    public LigneCommandeEntity convertToEntity(LigneCommandeDTO dto) {
        LigneCommandeEntity entity = new LigneCommandeEntity();
        entity.setId(dto.getId());
        entity.setDate(dto.getDate());
        entity.setDescription(dto.getDescription());
        entity.setHeure(dto.getHeure());
        entity.setNombre(dto.getNombre());
        entity.setProduit(dto.getProduit());
        entity.setSensTrafic(dto.getSensTrafic());
        entity.setTarifUnifie(dto.getTarifUnifie());
        entity.setTcConv(dto.getTcConv());
        entity.setTcSuppl(dto.getTcSuppl());
        entity.setTonnageMinimum(dto.getTonnageMinimum());
        entity.setTonnageReel(dto.getTonnageReel());
        entity.setCommandeId(dto.getCommandeId());
        entity.setPrestationId(dto.getPrestationId());

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
