package org.backend.gcmd.mapper;

import org.backend.gcmd.dto.LigneBpDTO;
import org.backend.gcmd.entity.LigneBpEntity;
import org.backend.gcmd.repository.BulltinPrestationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LigneBpMapper implements Mapper<LigneBpDTO, LigneBpEntity> {

    @Autowired
    BulltinPrestationRepository bulltinprestationRepository;

    @Override
    public Page<LigneBpDTO> convertToPageDto(Page<LigneBpEntity> page) {
        return page.map(this::convertToDto);
    }

//    public List<LigneBpDTO> convertToListDto(List<LigneBpEntity> list) {
//        List<LigneBpDTO> ligneBpDTOList=new ArrayList<>();
//        for (LigneBpEntity ligneBpEntity : list) {
//            ligneBpDTOList.add(convertToDto(ligneBpEntity));
//        }
//        return ligneBpDTOList;
//    }

    @Override
    public LigneBpDTO convertToDto(LigneBpEntity entity) {
        LigneBpDTO dto = new LigneBpDTO();
        dto.setId(entity.getId());
        dto.setDate(entity.getDate());
        dto.setHeure(entity.getHeure());
        dto.setNombre(entity.getNombre());
        dto.setPrestations(entity.getPrestations());
        dto.setProduit(entity.getProduit());
        dto.setSensTrafic(entity.getSensTrafic());
        dto.setTarifUnifie(entity.getTarifUnifie());
        dto.setTcConv(entity.getTcConv());
        dto.setTcSuppl(entity.getTcSuppl());
        dto.setTonnageMinimum(entity.getTonnageMinimum());
        dto.setTonnageReel(entity.getTonnageReel());
        dto.setIdLigneCommande(entity.getIdLigneCommande());
        return dto;
    }

    @Override
    public LigneBpEntity convertToEntity(LigneBpDTO dto) {
        LigneBpEntity entity = new LigneBpEntity();
        entity.setId(dto.getId());
        entity.setDate(dto.getDate());
        entity.setHeure(dto.getHeure());
        entity.setNombre(dto.getNombre());
        entity.setPrestations(dto.getPrestations());
        entity.setProduit(dto.getProduit());
        entity.setSensTrafic(dto.getSensTrafic());
        entity.setTarifUnifie(dto.getTarifUnifie());
        entity.setTcConv(dto.getTcConv());
        entity.setTcSuppl(dto.getTcSuppl());
        entity.setTonnageMinimum(dto.getTonnageMinimum());
        entity.setTonnageReel(dto.getTonnageReel());
        entity.setIdLigneCommande(dto.getIdLigneCommande());
        if(entity.getBulltinPrestation()!=null)
            dto.setBulltinPrestationId(entity.getBulltinPrestation().getId());
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
