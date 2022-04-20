package org.backend.gcmd.controller;

import org.backend.gcmd.dto.MouvementDTO;
import org.backend.gcmd.service.MouvementService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Gcmd_mouvement")
public class MouvementController {

    private final MouvementService mouvementService;

    public MouvementController(MouvementService mouvementService) {
        this.mouvementService = mouvementService;
    }

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

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        mouvementService.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<Page<MouvementDTO>> findAll(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(mouvementService.findAll(pageable));
    }
}
