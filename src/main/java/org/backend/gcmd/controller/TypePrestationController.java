package org.backend.gcmd.controller;

import org.backend.gcmd.dto.TypePrestationDTO;
import org.backend.gcmd.service.TypePrestationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Gcmd_typePrestation")
public class TypePrestationController {
	@Autowired
	private TypePrestationService typePrestationService;

	@GetMapping("{id}")
	public ResponseEntity<TypePrestationDTO> findById(@PathVariable Long id) {
		TypePrestationDTO typePrestationDTO = typePrestationService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(typePrestationDTO);
	}

	@PostMapping
	public ResponseEntity<TypePrestationDTO> save(@RequestBody TypePrestationDTO typePrestationDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(typePrestationService.save(typePrestationDTO));
	}

	@PutMapping("{id}")
	public ResponseEntity<TypePrestationDTO> update(@PathVariable Long id,
			@RequestBody TypePrestationDTO typePrestationDTO) {
		typePrestationDTO.setId(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(typePrestationService.update(typePrestationDTO));
	}

	@GetMapping
	public ResponseEntity<Page<TypePrestationDTO>> findAllByDeletedFalse(Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(typePrestationService.findAllByDeletedFalse(pageable));
	}
}
