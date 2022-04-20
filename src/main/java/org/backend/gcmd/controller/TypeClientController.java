package org.backend.gcmd.controller;

import org.backend.gcmd.dto.TypeClientDTO;
import org.backend.gcmd.service.TypeClientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Gcmd_typeClient")
public class TypeClientController {

    private final TypeClientService typeClientService;

    public TypeClientController(TypeClientService typeClientService) {
        this.typeClientService = typeClientService;
    }

    @GetMapping("{id}")
    public ResponseEntity<TypeClientDTO> findById(@PathVariable Long id) {
        TypeClientDTO typeClientDTO = typeClientService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(typeClientDTO);
    }

    @PostMapping
    public ResponseEntity<TypeClientDTO> save(@RequestBody TypeClientDTO typeClientDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(typeClientService.save(typeClientDTO));
    }

    @PutMapping("{id}")
    public ResponseEntity<TypeClientDTO> update(@PathVariable Long id,
                                           @RequestBody TypeClientDTO typeClientDTO) {
        typeClientDTO.setId(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(typeClientService.update(typeClientDTO));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        typeClientService.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<Page<TypeClientDTO>> findAll(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(typeClientService.findAll(pageable));
    }
}