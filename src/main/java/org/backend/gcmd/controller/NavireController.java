package org.backend.gcmd.controller;

import org.backend.gcmd.dto.NavireDTO;
import org.backend.gcmd.service.NavireService;
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
@RequestMapping("/navires")
public class NavireController {
	@Autowired
	private NavireService navireService;

	@GetMapping("{id}")
	public ResponseEntity<NavireDTO> findById(@PathVariable Long id) {
		NavireDTO navireDTO = navireService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(navireDTO);
	}

	@PostMapping
	public ResponseEntity<NavireDTO> save(@RequestBody NavireDTO navireDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(navireService.save(navireDTO));
	}

	@PutMapping("{id}")
	public ResponseEntity<NavireDTO> update(@PathVariable Long id, @RequestBody NavireDTO navireDTO) {
		navireDTO.setId(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(navireService.update(navireDTO));
	}

	@GetMapping
	public ResponseEntity<Page<NavireDTO>> findAllByDeletedFalse(Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(navireService.findAllByDeletedFalse(pageable));
	}
}
