package org.backend.gdc.controller;

import org.backend.gdc.dto.LigneCommandeDTO;
import org.backend.gdc.service.LigneCommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lignes_cmd")
public class LigneCommandeController {
	

	@Autowired
	private LigneCommandeService ligneCommandeService;

	@GetMapping("{id}")
	public ResponseEntity<LigneCommandeDTO> findById(@PathVariable Long id) {
		LigneCommandeDTO ligneCommandeDTO = ligneCommandeService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(ligneCommandeDTO);
	}

	@PostMapping
	public ResponseEntity<LigneCommandeDTO> save(@RequestBody LigneCommandeDTO ligneCommandeDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(ligneCommandeService.save(ligneCommandeDTO));
	}

	@PutMapping("{id}")
	public ResponseEntity<LigneCommandeDTO> update(@PathVariable Long id,
			@RequestBody LigneCommandeDTO ligneCommandeDTO) {
		ligneCommandeDTO.setId(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(ligneCommandeService.update(ligneCommandeDTO));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		ligneCommandeService.delete(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@GetMapping
	public ResponseEntity<Page<LigneCommandeDTO>> findAll(Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(ligneCommandeService.findAll(pageable));
	}
}
