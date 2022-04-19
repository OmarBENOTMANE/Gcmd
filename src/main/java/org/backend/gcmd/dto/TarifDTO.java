package org.backend.gcmd.dto;

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

    private double tarifHt;

    private double tarifTtc;

    private Long prestationId;

}
