package org.backend.gdc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "tarifs")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TarifDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double tarif_ht;

    private double tarif_ttc;

}
