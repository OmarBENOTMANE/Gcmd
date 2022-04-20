package org.backend.gcmd.controller;

import org.backend.gcmd.dto.UniteOrganisationelDTO;
import org.backend.gcmd.service.UniteOrganisationelService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Gcmd_uniteOrganisationel")
public class UniteOrganisationelController {

    private final UniteOrganisationelService uniteOrganisationelService;

    public UniteOrganisationelController(UniteOrganisationelService uniteOrganisationelService) {
        this.uniteOrganisationelService = uniteOrganisationelService;
    }

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
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(uniteOrganisationelService.update(uniteOrganisationelDTO));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        uniteOrganisationelService.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<Page<UniteOrganisationelDTO>> findAll(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(uniteOrganisationelService.findAll(pageable));
    }
}
