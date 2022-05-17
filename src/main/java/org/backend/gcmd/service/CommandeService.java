package org.backend.gcmd.service;

import org.backend.gcmd.dto.BulltinPrestationDTO;
import org.backend.gcmd.dto.CommandeDTO;
import org.backend.gcmd.dto.DevisDTO;
import org.backend.gcmd.dto.EscaleDTO;
import org.backend.gcmd.entity.CommandeEntity;
import org.backend.gcmd.exceptions.technical.ObjectNotFoundException;
import org.backend.gcmd.mapper.BulltinPrestationMapper;
import org.backend.gcmd.mapper.CommandeMapper;
import org.backend.gcmd.mapper.DevisMapper;
import org.backend.gcmd.mapper.EscaleMapper;
import org.backend.gcmd.repository.BulltinPrestationRepository;
import org.backend.gcmd.repository.CommandeRepository;
import org.backend.gcmd.validator.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;
    @Autowired
    private CommandeMapper commandeMapper;

    @Autowired
    private BulltinPrestationService bulltinPrestationService;
    @Autowired
    private BulltinPrestationMapper bulltinPrestationMapper;

    @Autowired
    private EscaleService escaleService;
    @Autowired
    private EscaleMapper escaleMapper;

    @Autowired
    private DevisService devisService;
    @Autowired
    private DevisMapper devisMapper;

    public CommandeDTO findById(Long id) {
        Validate.notNull(id, "id mus be not null");
        Optional<CommandeEntity> entity = commandeRepository.findById(id);
        if (entity.isPresent()) {
            return commandeMapper.convertToDto(entity.get());
        } else {
            throw new ObjectNotFoundException("CommandeDTO not found");
        }
    }
    public Page<CommandeDTO> findCommandeEntitiesByBulltinPrestation_Id(Long bpId,Pageable page) {
        Validate.notNull(bpId, "id mus be not null");
        Page<CommandeEntity> entity = commandeRepository.findCommandeEntitiesByBulltinPrestation_Id(bpId,page);
            return commandeMapper.convertToPageDto(entity);

    }





    public CommandeDTO save(CommandeDTO dto) {
        Validate.notNull(dto, "CommandeDTO must be not null");
        CommandeEntity entity = commandeMapper.convertToEntity(dto);
        CommandeEntity saved = commandeRepository.save(entity);
        return commandeMapper.convertToDto(saved);
    }

    public CommandeDTO update(CommandeDTO dto) {
        Validate.notNull(dto, "CommandeDTO must be not null");
        Validate.notNull(dto.getId(), "CommandeDTO id must be not null");
        findById(dto.getId());
        CommandeEntity entity = commandeMapper.convertToEntity(dto);
        if(dto.getBulltinPrestationId()!= null){
            BulltinPrestationDTO bulltinPrestationDTO = bulltinPrestationService.findById(dto.getBulltinPrestationId());
            entity.setBulltinPrestation(bulltinPrestationMapper.convertToEntity(bulltinPrestationDTO));
        }
        if(dto.getEscaleId()!= null){

        EscaleDTO escaleDTO = escaleService.findById(dto.getEscaleId());
        entity.setEscale(escaleMapper.convertToEntity(escaleDTO));}
        if(dto.getDevisId()!= null){
        DevisDTO devisDTO = devisService.findById(dto.getDevisId());
        entity.setDevis(devisMapper.convertToEntity(devisDTO));}
        CommandeEntity saved = commandeRepository.save(entity);
        return commandeMapper.convertToDto(saved);
    }

    public Page<CommandeDTO> findAllByDeletedFalse(Pageable pageable) {
        Page<CommandeEntity> page = commandeRepository.findAllByDeletedFalse(pageable);
        return commandeMapper.convertToPageDto(page);
    }

    public Page<CommandeDTO> findCmdNotAffected(Pageable pageable) {
        Page<CommandeEntity> page = commandeRepository.findCommandByBulltinPrestationIsNull(pageable);
        return commandeMapper.convertToPageDto(page);
    }
}
