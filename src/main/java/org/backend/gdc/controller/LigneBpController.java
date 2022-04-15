package org.backend.gdc.controller;

import org.backend.gdc.dto.LigneBpDTO;
import org.backend.gdc.service.LigneBpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lignes_bp")
public class LigneBpController {


    @Autowired
    private LigneBpService ligneBpService;

    @GetMapping("{id}")
    public ResponseEntity<LigneBpDTO> findById(@PathVariable Long id) {
        LigneBpDTO ligneBpDTO = ligneBpService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(ligneBpDTO);
    }

    @PostMapping
    public ResponseEntity<LigneBpDTO> save(@RequestBody LigneBpDTO ligneBpDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ligneBpService.save(ligneBpDTO));
    }

    @PutMapping("{id}")
    public ResponseEntity<LigneBpDTO> update(@PathVariable Long id,
                                             @RequestBody LigneBpDTO ligneBpDTO) {
        ligneBpDTO.setId(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(ligneBpService.update(ligneBpDTO));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ligneBpService.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<Page<LigneBpDTO>> findAll(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(ligneBpService.findAll(pageable));
    }
}
