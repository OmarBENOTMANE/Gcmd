package org.backend.gcmd.controller;

import org.backend.gcmd.dto.DevisDTO;
import org.backend.gcmd.service.DevisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/devis")
public class DevisController {
    @Autowired
    private DevisService devisService;


    @GetMapping("{id}")
    public ResponseEntity<DevisDTO> findById(@PathVariable Long id) {
        DevisDTO devisDTO = devisService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(devisDTO);
    }

    @PostMapping
    public ResponseEntity<DevisDTO> save(@RequestBody DevisDTO devisDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(devisService.save(devisDTO));
    }

    @PutMapping("{id}")
    public ResponseEntity<DevisDTO> update(@PathVariable Long id,
                                           @RequestBody DevisDTO devisDTO) {
        devisDTO.setId(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(devisService.update(devisDTO));
    }

//    @DeleteMapping("{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id) {
//        devisService.delete(id);
//        return new ResponseEntity<>(HttpStatus.ACCEPTED);
//    }

    @GetMapping
    public ResponseEntity<Page<DevisDTO>> findAll(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(devisService.findAll(pageable));
    }

    @GetMapping
    public ResponseEntity<Page<DevisDTO>> findAllByDeletedFalse(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(devisService.findAllByDeletedFalse(pageable));
    }
}
