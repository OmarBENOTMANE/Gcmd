package org.backend.gcmd.controller;

import org.backend.gcmd.dto.UniteOrganisationelDTO;
import org.backend.gcmd.service.UniteOrganisationelService;
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
@RequestMapping("/Gcmd_uniteOrganisationel")
public class UniteOrganisationelController {
	@Autowired
	private UniteOrganisationelService uniteOrganisationelService;

	@GetMapping("{id}")
	public ResponseEntity<UniteOrganisationelDTO> findById(@PathVariable Long id) {
		UniteOrganisationelDTO uniteOrganisationelDTO = uniteOrganisationelService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(uniteOrganisationelDTO);
	}

	@PostMapping
	public ResponseEntity<UniteOrganisationelDTO> save(@RequestBody UniteOrganisationelDTO uniteOrganisationelDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(uniteOrganisationelService.save(uniteOrganisationelDTO));
	}

	@PutMapping("{id}")
	public ResponseEntity<UniteOrganisationelDTO> update(@PathVariable Long id,
			@RequestBody UniteOrganisationelDTO uniteOrganisationelDTO) {
		uniteOrganisationelDTO.setId(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(uniteOrganisationelService.update(uniteOrganisationelDTO));
	}

	@GetMapping
	public ResponseEntity<Page<UniteOrganisationelDTO>> findAllByDeletedFalse(Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(uniteOrganisationelService.findAllByDeletedFalse(pageable));
	}
}
