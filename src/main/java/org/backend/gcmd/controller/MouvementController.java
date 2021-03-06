package org.backend.gcmd.controller;

import org.backend.gcmd.dto.MouvementDTO;
import org.backend.gcmd.service.MouvementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Gcmd_mouvement")
public class MouvementController {
    @Autowired
    private MouvementService mouvementService;

    @GetMapping("{id}")
    public ResponseEntity<MouvementDTO> findById(@PathVariable Long id) {
        MouvementDTO mouvementDTO = mouvementService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(mouvementDTO);
    }

    @PostMapping
    public ResponseEntity<MouvementDTO> save(@RequestBody MouvementDTO mouvementDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mouvementService.save(mouvementDTO));
    }

    @PutMapping("{id}")
    public ResponseEntity<MouvementDTO> update(@PathVariable Long id,
                                               @RequestBody MouvementDTO mouvementDTO) {
        mouvementDTO.setId(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(mouvementService.update(mouvementDTO));
    }

    @GetMapping
    public ResponseEntity<Page<MouvementDTO>> findAllByDeletedFalse(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(mouvementService.findAllByDeletedFalse(pageable));
    }

}
