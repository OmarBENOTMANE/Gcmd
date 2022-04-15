package org.backend.gcmd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "Gcmd_tarif")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TarifEntity {

    private Long id;

    private double tarifHt;

    private double tarifTtc;

}
