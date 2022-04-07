package org.backend.gdc.dto;

import lombok.*;

import javax.persistence.*;

@Data
public class EscaleDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numero_escale;
}
