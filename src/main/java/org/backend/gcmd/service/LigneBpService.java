package org.backend.gcmd.service;

import org.backend.gcmd.dto.CommandeDTO;
import org.backend.gcmd.dto.LigneBpDTO;
import org.backend.gcmd.dto.LigneCommandeDTO;
import org.backend.gcmd.entity.BulltinPrestationEntity;
import org.backend.gcmd.entity.CommandeEntity;
import org.backend.gcmd.entity.LigneBpEntity;
import org.backend.gcmd.entity.LigneCommandeEntity;
import org.backend.gcmd.exceptions.technical.ObjectNotFoundException;
import org.backend.gcmd.mapper.CommandeMapper;
import org.backend.gcmd.mapper.LigneBpMapper;
import org.backend.gcmd.mapper.LigneCommandeMapper;
import org.backend.gcmd.repository.BulltinPrestationRepository;
import org.backend.gcmd.repository.CommandeRepository;
import org.backend.gcmd.repository.LigneBpRepository;
import org.backend.gcmd.repository.LigneCommandeRepository;
import org.backend.gcmd.validator.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LigneBpService {

    @Autowired
    private CommandeMapper cmdMapper;

    @Autowired
    private CommandeRepository cmdRepository;

    @Autowired
    private LigneBpRepository ligneBpRepository;

    @Autowired
    private BulltinPrestationRepository bprestationRepository;

    @Autowired
    private LigneCommandeRepository ligneCommandeRepository;

    @Autowired
    private LigneCommandeMapper ligneCommandeMapper;

    @Autowired
    private LigneBpMapper ligneBpMapper;

    public LigneBpDTO findById(Long id) {
        Validate.notNull(id, "id mus be not null");
        Optional<LigneBpEntity> entity = ligneBpRepository.findById(id);
        if (entity.isPresent()) {
            return ligneBpMapper.convertToDto(entity.get());
        } else {
            throw new ObjectNotFoundException("LigneBpDTO not found");
        }
    }

    public LigneBpDTO save(LigneBpDTO dto) {
        Validate.notNull(dto, "LigneBpDTO must be not null");
        LigneBpEntity entity = ligneBpMapper.convertToEntity(dto);
        LigneBpEntity saved = ligneBpRepository.save(entity);
        return ligneBpMapper.convertToDto(saved);
    }

    public LigneBpDTO update(LigneBpDTO dto) {
        Validate.notNull(dto, "LigneBpDTO must be not null");
        Validate.notNull(dto.getId(), "LigneBpDTOO id must be not null");
        findById(dto.getId());
        LigneBpEntity entity = ligneBpMapper.convertToEntity(dto);
        LigneBpEntity saved = ligneBpRepository.save(entity);
        return ligneBpMapper.convertToDto(saved);
    }

    public Page<LigneBpDTO> findAllByDeletedFalse(Pageable pageable) {
        Page<LigneBpEntity> page = ligneBpRepository.findAllByDeletedFalse(pageable);
        return ligneBpMapper.convertToPageDto(page);
    }

    public List<LigneBpDTO> findByIdLigneCommande(Long idLigneCommande) {
        List<LigneBpEntity> list = ligneBpRepository.findByIdLigneCommande(idLigneCommande);
        return ligneBpMapper.convertToDtoList(list);
    }

    public List<LigneBpDTO>  saveligneBPs(CommandeDTO cmdDTO) {
        Validate.notNull(cmdDTO, "cmd must be not null");
        CommandeEntity cmd = cmdMapper.convertToEntity(cmdDTO);
        cmdRepository.save(cmd);
        Optional<BulltinPrestationEntity> bp = bprestationRepository.findById(cmdDTO.getBulltinPrestationId());
        List<LigneCommandeEntity> lineCmds = ligneCommandeRepository.findAllByCommande_Id(cmdDTO.getId());
        List<LigneBpDTO> lignebps = new ArrayList<>();
        for (LigneCommandeEntity lcmd: lineCmds) {
            LigneBpEntity entity = new LigneBpEntity();
            entity.setDate(lcmd.getDate());
            entity.setNombre(lcmd.getNombre());
            entity.setSensTrafic(lcmd.getSensTrafic());
            entity.setHeure(lcmd.getHeure());
            entity.setTarifUnifie(lcmd.getTarifUnifie());
            entity.setTcConv(lcmd.getTcConv());
            entity.setTonnageMinimum(lcmd.getTonnageMinimum());
            entity.setTonnageReel(lcmd.getTonnageReel());
            entity.setTcSuppl(lcmd.getTcSuppl());
            entity.setPrestations(lcmd.getPrestations());
            entity.setProduit(lcmd.getProduit());
            entity.setBulltinPrestation(bp.get());
            entity.setDeleted(false);
            LigneBpEntity saved = ligneBpRepository.save(entity);
            lignebps.add(ligneBpMapper.convertToDto(entity));
            if (saved!= null){
                lcmd.setIsAffected(true);
                ligneCommandeRepository.save(lcmd);
            }
        }

        return lignebps;
    }
    public LigneBpDTO  saveligneBP(LigneCommandeDTO lcmd) {
        Validate.notNull(lcmd, "Lignecmd must be not null");
        Optional<CommandeEntity> cmd = cmdRepository.findById(lcmd.getCommandeId());
        lcmd.setIsAffected(true);
        LigneBpEntity entity = new LigneBpEntity();
        entity.setDate(lcmd.getDate());
        entity.setNombre(lcmd.getNombre());
        entity.setSensTrafic(lcmd.getSensTrafic());
        entity.setHeure(lcmd.getHeure());
        entity.setTarifUnifie(lcmd.getTarifUnifie());
        entity.setTcConv(lcmd.getTcConv());
        entity.setTonnageMinimum(lcmd.getTonnageMinimum());
        entity.setTonnageReel(lcmd.getTonnageReel());
        entity.setTcSuppl(lcmd.getTcSuppl());
        entity.setPrestations(lcmd.getPrestations());
        entity.setProduit(lcmd.getProduit());
        entity.setBulltinPrestation(cmd.get().getBulltinPrestation());
        entity.setDeleted(false);
        LigneBpEntity saved = ligneBpRepository.save(entity);
        if (saved!= null){
            ligneCommandeRepository.save(ligneCommandeMapper.convertToEntity(lcmd));
        }
        return  ligneBpMapper.convertToDto(saved);
    }

    public Page<LigneBpDTO> findAllByBulltinPrestation_Id(Long id,Pageable pageable) {
        Page<LigneBpEntity> page = ligneBpRepository.findAllByBulltinPrestation_Id(id ,pageable);
        return ligneBpMapper.convertToPageDto(page);
    }

}
