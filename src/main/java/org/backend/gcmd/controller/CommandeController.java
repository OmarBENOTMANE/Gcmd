package org.backend.gcmd.controller;

import org.backend.gcmd.dto.CommandeDTO;
import org.backend.gcmd.service.CommandeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/commandes")
public class CommandeController {

    private final CommandeService CommandeService;

    public CommandeController(org.backend.gcmd.service.CommandeService commandeService) {
        CommandeService = commandeService;
    }

    @GetMapping("{id}")
    public ResponseEntity<CommandeDTO> findById(@PathVariable Long id) {
        CommandeDTO CommandeDTO = CommandeService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(CommandeDTO);
    }

    @PostMapping
    public ResponseEntity<CommandeDTO> save(@RequestBody CommandeDTO CommandeDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(CommandeService.save(CommandeDTO));
    }

    @PutMapping("{id}")
    public ResponseEntity<CommandeDTO> update(@PathVariable Long id,
                                              @RequestBody CommandeDTO CommandeDTO) {
        CommandeDTO.setId(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(CommandeService.update(CommandeDTO));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        CommandeService.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<Page<CommandeDTO>> findAll(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(CommandeService.findAll(pageable));
    }
}
