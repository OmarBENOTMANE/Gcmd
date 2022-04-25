package org.backend.gcmd.mapper;

import org.backend.gcmd.dto.CommandeDTO;
import org.backend.gcmd.entity.CommandeEntity;
import org.backend.gcmd.repository.BulltinPrestationRepository;
import org.backend.gcmd.repository.DevisRepository;
import org.backend.gcmd.repository.EscaleRepository;
import org.backend.gcmd.service.BulltinPrestationService;
import org.backend.gcmd.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommandeMapper implements Mapper<CommandeDTO, CommandeEntity> {

    @Override
    public Page<CommandeDTO> convertToPageDto(Page<CommandeEntity> page) {
        return page.map(this::convertToDto);
    }

    @Autowired
    private BulltinPrestationRepository bulltinPrestationRepository;
    @Autowired
    private EscaleRepository escaleRepository;
    @Autowired
    private DevisRepository devisRepository;

    @Override
    public CommandeDTO convertToDto(CommandeEntity entity) {
        CommandeDTO dto = new CommandeDTO();
        dto.setId(entity.getId());
        dto.setBulletinReception(entity.getBulletinReception());
        dto.setCapitaine(entity.getCapitaine());
        dto.setConnaissement(entity.getConnaissement());
        dto.setConsignataire(entity.getConsignataire());
        dto.setDateAmarage(entity.getDateAmarage());
        dto.setDateDesamarage(entity.getDateDesamarage());
        dto.setJaugeBrute(entity.getJaugeBrute());
        dto.setLht(entity.getLht());
        dto.setMumeroCommande(entity.getMumeroCommande());
        dto.setMumeroCredit(entity.getMumeroCredit());
        dto.setNavire(entity.getNavire());
        dto.setNumeroBc(entity.getNumeroBc());
        dto.setNumeroEscale(entity.getNumeroEscale());
        dto.setPoste(entity.getPoste());
        dto.setEscaleId(entity.getEscaleId());
        dto.setDevisId(entity.getDevisId());
        dto.setBulltinPrestationId(entity.getBulltinPrestationId());
        return dto;
    }

    @Override
    public CommandeEntity convertToEntity(CommandeDTO dto) {
        CommandeEntity entity = new CommandeEntity();
        entity.setId(dto.getId());
        entity.setBulletinReception(dto.getBulletinReception());
        entity.setCapitaine(dto.getCapitaine());
        entity.setConnaissement(dto.getConnaissement());
        entity.setConsignataire(dto.getConsignataire());
        entity.setDateAmarage(dto.getDateAmarage());
        entity.setDateDesamarage(dto.getDateDesamarage());
        entity.setJaugeBrute(dto.getJaugeBrute());
        entity.setLht(dto.getLht());
        entity.setMumeroCommande(dto.getMumeroCommande());
        entity.setMumeroCredit(dto.getMumeroCredit());
        entity.setNavire(dto.getNavire());
        entity.setNumeroBc(dto.getNumeroBc());
        entity.setNumeroEscale(dto.getNumeroEscale());
        entity.setPoste(dto.getPoste());
        entity.setEscaleId(dto.getEscaleId());
        entity.setDevisId(dto.getDevisId());
        entity.setBulltinPrestationId(dto.getBulltinPrestationId());
        entity.setBulltinPrestation(bulltinPrestationRepository.findById(dto.getBulltinPrestationId()).get());
        entity.setEscale(escaleRepository.findById(dto.getEscaleId()).get());
        entity.setDevis(devisRepository.findById(dto.getDevisId()).get());
        return entity;
    }

    @Override
    public List<CommandeDTO> convertToDtoList(List<CommandeEntity> entities) {
        return entities.stream().map(this::convertToDto).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public List<CommandeEntity> convertToEntitiesList(List<CommandeDTO> dtos) {
        return dtos.stream().map(this::convertToEntity).collect(Collectors.toCollection(ArrayList::new));
    }
}
