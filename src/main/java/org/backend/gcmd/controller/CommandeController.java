package org.backend.gcmd.controller;

import org.backend.gcmd.dto.CommandeDTO;
import org.backend.gcmd.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/gcmd/v1/commandes")
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
	public ResponseEntity<CommandeDTO> update(@PathVariable Long id, @RequestBody CommandeDTO commandeDTO) {
		commandeDTO.setId(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(commandeService.update(commandeDTO));
	}

	@GetMapping
	public ResponseEntity<Page<CommandeDTO>> findAllByDeletedFalse(Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(commandeService.findAllByDeletedFalse(pageable));
	}
}
