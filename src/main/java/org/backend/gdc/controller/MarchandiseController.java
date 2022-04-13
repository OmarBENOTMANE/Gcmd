package org.backend.gdc.controller;

import org.backend.gdc.dto.MarchandiseDTO;
import org.backend.gdc.service.MarchandiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/marchandises")
public class MarchandiseController {
	

	@Autowired
	private MarchandiseService MarchandiseService;

	@GetMapping("{id}")
	public ResponseEntity<MarchandiseDTO> findById(@PathVariable Long id) {
		MarchandiseDTO MarchandiseDTO = MarchandiseService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(MarchandiseDTO);
	}

	@PostMapping
	public ResponseEntity<MarchandiseDTO> save(@RequestBody MarchandiseDTO MarchandiseDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(MarchandiseService.save(MarchandiseDTO));
	}

	@PutMapping("{id}")
	public ResponseEntity<MarchandiseDTO> update(@PathVariable Long id,
			@RequestBody MarchandiseDTO MarchandiseDTO) {
		MarchandiseDTO.setId(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(MarchandiseService.update(MarchandiseDTO));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		MarchandiseService.delete(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@GetMapping
	public ResponseEntity<Page<MarchandiseDTO>> findAll(Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(MarchandiseService.findAll(pageable));
	}
}