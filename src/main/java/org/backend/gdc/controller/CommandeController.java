package org.backend.gdc.controller;

import org.backend.gdc.dto.CommandeDTO;
import org.backend.gdc.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/commandes")
public class CommandeController {
	

	@Autowired
	private CommandeService CommandeService;

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
