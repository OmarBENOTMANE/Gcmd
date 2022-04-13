package org.backend.gdc.controller;

import org.backend.gdc.dto.PermissionDTO;
import org.backend.gdc.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/permissions")
public class PermissionController {
	

	@Autowired
	private PermissionService permissionService;

	@GetMapping("{id}")
	public ResponseEntity<PermissionDTO> findById(@PathVariable Long id) {
		PermissionDTO permissionDTO = permissionService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(permissionDTO);
	}

	@PostMapping
	public ResponseEntity<PermissionDTO> save(@RequestBody PermissionDTO permissionDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(permissionService.save(permissionDTO));
	}

	@PutMapping("{id}")
	public ResponseEntity<PermissionDTO> update(@PathVariable Long id,
			@RequestBody PermissionDTO permissionDTO) {
		permissionDTO.setId(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(permissionService.update(permissionDTO));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		permissionService.delete(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@GetMapping
	public ResponseEntity<Page<PermissionDTO>> findAll(Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(permissionService.findAll(pageable));
	}
}
