package org.backend.gdc.controller;

import org.backend.gdc.dto.LigneDevisDTO;
import org.backend.gdc.service.LigneDevisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lignes_devis")
public class LigneDevisController {
	

	@Autowired
	private LigneDevisService ligneDevisService;

	@GetMapping("{id}")
	public ResponseEntity<LigneDevisDTO> findById(@PathVariable Long id) {
		LigneDevisDTO ligneDevisDTO = ligneDevisService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(ligneDevisDTO);
	}

	@PostMapping
	public ResponseEntity<LigneDevisDTO> save(@RequestBody LigneDevisDTO ligneDevisDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(ligneDevisService.save(ligneDevisDTO));
	}

	@PutMapping("{id}")
	public ResponseEntity<LigneDevisDTO> update(@PathVariable Long id,
			@RequestBody LigneDevisDTO ligneDevisDTO) {
		ligneDevisDTO.setId(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(ligneDevisService.update(ligneDevisDTO));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		ligneDevisService.delete(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@GetMapping
	public ResponseEntity<Page<LigneDevisDTO>> findAll(Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(ligneDevisService.findAll(pageable));
	}
}
