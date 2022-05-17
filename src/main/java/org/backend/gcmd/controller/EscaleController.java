package org.backend.gcmd.controller;

import org.backend.gcmd.dto.EscaleDTO;
import org.backend.gcmd.service.EscaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("escales")
public class EscaleController {
    @Autowired
    private EscaleService escaleService;

    @GetMapping("{id}")
    public ResponseEntity<EscaleDTO> findById(@PathVariable Long id) {
        EscaleDTO escaleDTO = escaleService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(escaleDTO);
    }

    @PostMapping
    public ResponseEntity<EscaleDTO> save(@RequestBody EscaleDTO escaleDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(escaleService.save(escaleDTO));
    }

    @PutMapping("{id}")
    public ResponseEntity<EscaleDTO> update(@PathVariable Long id,
                                            @RequestBody EscaleDTO escaleDTO) {
        escaleDTO.setId(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(escaleService.update(escaleDTO));
    }

    @GetMapping
    public ResponseEntity<Page<EscaleDTO>> findAllByDeletedFalse(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(escaleService.findAllByDeletedFalse(pageable));
    }
}
