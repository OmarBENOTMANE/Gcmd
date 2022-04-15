package org.backend.gdc.controller;

import org.backend.gdc.dto.BulltinPrestationDTO;
import org.backend.gdc.service.BulltinPrestationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bulltinPrestation")
public class BulltinPrestationController {


    @Autowired
    private BulltinPrestationService bulltinPrestationService;

    @GetMapping("{id}")
    public ResponseEntity<BulltinPrestationDTO> findById(@PathVariable Long id) {
        BulltinPrestationDTO bulltinPrestationDTO = bulltinPrestationService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(bulltinPrestationDTO);
    }

    @PostMapping
    public ResponseEntity<BulltinPrestationDTO> save(@RequestBody BulltinPrestationDTO bulltinPrestationDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bulltinPrestationService.save(bulltinPrestationDTO));
    }

    @PutMapping("{id}")
    public ResponseEntity<BulltinPrestationDTO> update(@PathVariable Long id,
                                                       @RequestBody BulltinPrestationDTO bulltinPrestationDTO) {
        bulltinPrestationDTO.setId(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(bulltinPrestationService.update(bulltinPrestationDTO));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bulltinPrestationService.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<Page<BulltinPrestationDTO>> findAll(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(bulltinPrestationService.findAll(pageable));
    }
}
