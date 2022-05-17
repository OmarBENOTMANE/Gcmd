package org.backend.gcmd.service;

import org.backend.gcmd.dto.LigneBpDTO;
import org.backend.gcmd.dto.LigneCommandeDTO;
import org.backend.gcmd.entity.LigneCommandeEntity;
import org.backend.gcmd.exceptions.technical.ObjectNotFoundException;
import org.backend.gcmd.mapper.CommandeMapper;
import org.backend.gcmd.mapper.LigneCommandeMapper;
import org.backend.gcmd.repository.LigneCommandeRepository;
import org.backend.gcmd.validator.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class LigneCommandeService {

    @Autowired
    private LigneCommandeRepository ligneCommandeRepository;

    @Autowired
    private LigneCommandeMapper ligneCommandeMapper;

    @Autowired
    private LigneBpService ligneBpService;

    @Autowired
    private CommandeService commandeService;

    @Autowired
    private CommandeMapper commandeMapper;

    public LigneCommandeDTO findById(Long id) {
        Validate.notNull(id, "id mus be not null");
        Optional<LigneCommandeEntity> entity = ligneCommandeRepository.findById(id);
        if (entity.isPresent()) {
            return ligneCommandeMapper.convertToDto(entity.get());
        } else {
            throw new ObjectNotFoundException("LigneCommandeDTO not found");
        }
    }

    public LigneCommandeDTO save(LigneCommandeDTO dto) {
        Validate.notNull(dto, "LigneCommandeDTO must be not null");
        LigneCommandeEntity entity = ligneCommandeMapper.convertToEntity(dto);
        LigneCommandeEntity saved = ligneCommandeRepository.save(entity);
        return ligneCommandeMapper.convertToDto(saved);
    }

    public LigneCommandeDTO update(LigneCommandeDTO dto) {
        Validate.notNull(dto, "LigneCommandeDTO must be not null");
        Validate.notNull(dto.getId(), "LigneCommandeDTO id must be not null");
        findById(dto.getId());
        LigneCommandeEntity entity = ligneCommandeMapper.convertToEntity(dto);
        if (dto.getCommandeId() != null) {
            entity.setCommande(commandeMapper.convertToEntity(commandeService.findById(dto.getCommandeId())));
        } else {
            entity.setCommande(null);
        }
        LigneCommandeEntity saved = ligneCommandeRepository.save(entity);
        return ligneCommandeMapper.convertToDto(saved);
    }

    public Page<LigneCommandeDTO> findAllByDeletedFalse(Pageable pageable) {
        Page<LigneCommandeEntity> page = ligneCommandeRepository.findAllByDeletedFalse(pageable);
        return ligneCommandeMapper.convertToPageDto(page);
    }

    public LigneCommandeDTO affecter(Long id) {
        Validate.notNull(id, "LigneCommandeDTO must be not null");
        LigneCommandeDTO lcdto = findById(id);
        update(lcdto);
        if (!lcdto.getIsAffected()) {
            LigneBpDTO lbpdto = genererbp(lcdto);
            lcdto.setGenlbp(lbpdto.getId());
            lcdto.setIsAffected(true);
            update(lcdto);
        } else {
            LigneBpDTO lbpdto = ligneBpService.findById(lcdto.getGenlbp());
            lbpdto.setDeleted(true);
            ligneBpService.update(lbpdto);
            lcdto.setGenlbp(null);
            lcdto.setIsAffected(false);
            update(lcdto);
        }
        return lcdto;
    }

    public LigneBpDTO genererbp(LigneCommandeDTO ligneCommandeDTO) {
        LigneBpDTO ligneBpDTO = new LigneBpDTO();
        ligneBpDTO.setPrestations(ligneCommandeDTO.getPrestations());
        ligneBpDTO.setDate(ligneCommandeDTO.getDate());
        ligneBpDTO.setHeure(ligneCommandeDTO.getHeure());
        ligneBpDTO.setSensTrafic(ligneCommandeDTO.getSensTrafic());
        ligneBpDTO.setTcSuppl(ligneCommandeDTO.getTcSuppl());
        ligneBpDTO.setTcConv(ligneCommandeDTO.getTcConv());
        ligneBpDTO.setNombre(ligneCommandeDTO.getNombre());
        ligneBpDTO.setTarifUnifie(ligneCommandeDTO.getTarifUnifie());
        ligneBpDTO.setTonnageReel(ligneCommandeDTO.getTonnageReel());
        ligneBpDTO.setTonnageMinimum(ligneCommandeDTO.getTonnageMinimum());
        ligneBpDTO = ligneBpService.save(ligneBpDTO);
        return ligneBpDTO;
    }

}
