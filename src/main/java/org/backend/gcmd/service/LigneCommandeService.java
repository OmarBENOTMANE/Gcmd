package org.backend.gcmd.service;

import org.backend.gcmd.dto.LigneBpDTO;
import org.backend.gcmd.dto.LigneCommandeDTO;
import org.backend.gcmd.entity.LigneCommandeEntity;
import org.backend.gcmd.exceptions.technical.ObjectNotFoundException;
import org.backend.gcmd.mapper.LigneCommandeMapper;
import org.backend.gcmd.repository.LigneCommandeRepository;
import org.backend.gcmd.validator.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
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
        LigneCommandeEntity saved = ligneCommandeRepository.save(entity);
        return ligneCommandeMapper.convertToDto(saved);
    }

    public Page<LigneCommandeDTO> findAllByDeletedFalse(Pageable pageable) {
        Page<LigneCommandeEntity> page = ligneCommandeRepository.findAllByDeletedFalse(pageable);
        return ligneCommandeMapper.convertToPageDto(page);
    }

    public LigneCommandeDTO affecter(Long id, Boolean isAffected) {
        Validate.notNull(id, "LigneCommandeDTO must be not null");
        Validate.notNull(isAffected, "LigneCommandeDTO id must be not null");
        LigneCommandeDTO lcdto = findById(id);
        lcdto.setIsAffected(isAffected);
        update(lcdto);
        if (lcdto.getIsAffected() == true) {
            genererbp(lcdto);
        } else {
            List<LigneBpDTO> byIdLigneCommande = ligneBpService.findByIdLigneCommande(lcdto.getId());
            if (!CollectionUtils.isEmpty(byIdLigneCommande)) {
                byIdLigneCommande.get(0).setDeleted(true);
                ligneBpService.save(byIdLigneCommande.get(0));
            }
        }
        return lcdto;
    }

    public LigneBpDTO genererbp(LigneCommandeDTO ligneCommandeDTO) {
        LigneBpDTO ligneBpDTO = new LigneBpDTO();
        ligneBpDTO.setPrestation(ligneCommandeDTO.getPrestation());
        ligneBpDTO.setDate(ligneCommandeDTO.getDate());
        ligneBpDTO.setHeure(ligneCommandeDTO.getHeure());
        ligneBpDTO.setSensTrafic(ligneCommandeDTO.getSensTrafic());
        ligneBpDTO.setTcSuppl(ligneCommandeDTO.getTcSuppl());
        ligneBpDTO.setTcConv(ligneCommandeDTO.getTcConv());
        ligneBpDTO.setNombre(ligneCommandeDTO.getNombre());
        ligneBpDTO.setTarifUnifie(ligneCommandeDTO.getTarifUnifie());
        ligneBpDTO.setTonnageReel(ligneCommandeDTO.getTonnageReel());
        ligneBpDTO.setTonnageMinimum(ligneCommandeDTO.getTonnageMinimum());
        ligneBpDTO.setIdLigneCommande(ligneCommandeDTO.getId());
        ligneBpDTO = ligneBpService.save(ligneBpDTO);
        return ligneBpDTO;
    }
}
