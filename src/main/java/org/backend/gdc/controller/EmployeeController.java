package org.backend.gdc.controller;

import org.backend.gdc.dto.EmployeeDTO;
import org.backend.gdc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDTO> findById(@PathVariable Long id) {
        EmployeeDTO employeeDTO = employeeService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(employeeDTO);
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> save(@RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.save(employeeDTO));
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDTO> update(@PathVariable Long id,
                                              @RequestBody EmployeeDTO employeeDTO) {
        employeeDTO.setId(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(employeeService.update(employeeDTO));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        employeeService.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<Page<EmployeeDTO>> findAll(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.findAll(pageable));
    }
}
