package org.backend.gcmd.mapper;

import org.backend.gcmd.dto.DevisDTO;
import org.backend.gcmd.entity.DevisEntity;
import org.backend.gcmd.repository.ClientRepository;
import org.backend.gcmd.repository.DevisRepository;
import org.backend.gcmd.repository.EscaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private EscaleRepository escaleRepository;
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public DevisDTO convertToDto(DevisEntity entity) {
        DevisDTO dto = new DevisDTO();
        dto.setId(entity.getId());
        dto.setMmMc(entity.getMmMc());
        dto.setBl(entity.getBl());
        dto.setDate(entity.getDate());
        dto.setDateFacturation(entity.getDateFacturation());
        dto.setDateSortie(entity.getDateSortie());
        dto.setDesignation(entity.getDesignation());
        dto.setEnginsColis(entity.getEnginsColis());
        dto.setImportExport(entity.getImportExport());
        dto.setNomClient(entity.getNomClient());
        dto.setNomNavire(entity.getNomNavire());
        dto.setNombreColis(entity.getNombreColis());
        dto.setNumeroCommande(entity.getNumeroCommande());
        dto.setNumeroMafi(entity.getNumeroMafi());
        dto.setPoids(entity.getPoids());
        dto.setEscaleId(entity.getEscaleId());
        dto.setClientId(entity.getClientId());
        return dto;
    }

    @Override
    public DevisEntity convertToEntity(DevisDTO dto) {
        DevisEntity entity = new DevisEntity();
        entity.setId(dto.getId());
        entity.setMmMc(dto.getMmMc());
        entity.setBl(dto.getBl());
        entity.setDate(dto.getDate());
        entity.setDateFacturation(dto.getDateFacturation());
        entity.setDateSortie(dto.getDateSortie());
        entity.setDesignation(dto.getDesignation());
        entity.setEnginsColis(dto.getEnginsColis());
        entity.setImportExport(dto.getImportExport());
        entity.setNomClient(dto.getNomClient());
        entity.setNomNavire(dto.getNomNavire());
        entity.setNombreColis(dto.getNombreColis());
        entity.setNumeroCommande(dto.getNumeroCommande());
        entity.setNumeroMafi(dto.getNumeroMafi());
        entity.setPoids(dto.getPoids());
        entity.setEscaleId(dto.getEscaleId());
        entity.setClientId(dto.getClientId());
        entity.setEscale(escaleRepository.findById(dto.getEscaleId()).get());
        entity.setClient(clientRepository.findById(dto.getClientId()).get());
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
