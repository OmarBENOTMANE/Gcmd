package org.backend.gcmd.controller;

import org.backend.gcmd.dto.TypeClientDTO;
import org.backend.gcmd.service.TypeClientService;
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
@RequestMapping("/Gcmd_typeClient")
public class TypeClientController {
	@Autowired
	private TypeClientService typeClientService;

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
	public ResponseEntity<TypeClientDTO> update(@PathVariable Long id, @RequestBody TypeClientDTO typeClientDTO) {
		typeClientDTO.setId(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(typeClientService.update(typeClientDTO));
	}

	@GetMapping
	public ResponseEntity<Page<TypeClientDTO>> findAllByDeletedFalse(Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(typeClientService.findAllByDeletedFalse(pageable));
	}
}
