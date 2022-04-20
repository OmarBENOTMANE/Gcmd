package org.backend.gcmd.controller;

import org.backend.gcmd.dto.ClientDTO;
import org.backend.gcmd.service.ClientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {


    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable Long id) {
        ClientDTO clientDTO = clientService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(clientDTO);
    }

    @PostMapping
    public ResponseEntity<ClientDTO> save(@RequestBody ClientDTO clientDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(clientDTO));
    }

    @PutMapping("{id}")
    public ResponseEntity<ClientDTO> update(@PathVariable Long id,
                                            @RequestBody ClientDTO clientDTO) {
        clientDTO.setId(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(clientService.update(clientDTO));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientService.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<Page<ClientDTO>> findAll(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findAll(pageable));
    }
}
