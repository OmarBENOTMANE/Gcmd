package org.backend.gcmd.controller;

import org.backend.gcmd.dto.CommandeDTO;
import org.backend.gcmd.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/gcmd/v1/commande")
public class CommandeController {
    @Autowired
    private CommandeService commandeService;


    @GetMapping("{id}")
    public ResponseEntity<CommandeDTO> findById(@PathVariable Long id) {
        CommandeDTO commandeDTO = commandeService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(commandeDTO);
    }

    @PostMapping
    public ResponseEntity<CommandeDTO> save(@RequestBody CommandeDTO commandeDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(commandeService.save(commandeDTO));
    }

    @PutMapping("{id}")
    public ResponseEntity<CommandeDTO> update(@PathVariable Long id,
                                              @RequestBody CommandeDTO commandeDTO) {
        commandeDTO.setId(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(commandeService.update(commandeDTO));
    }

//    @DeleteMapping("{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id) {
//        commandeService.delete(id);
//        return new ResponseEntity<>(HttpStatus.ACCEPTED);
//    }

    @GetMapping("/listCommandes")
    public ResponseEntity<Page<CommandeDTO>> findAll(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(commandeService.findAll(pageable));
    }
}
