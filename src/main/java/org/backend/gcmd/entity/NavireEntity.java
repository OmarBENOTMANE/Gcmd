package org.backend.gcmd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Table(name = "Gcmd_navire")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class NavireEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double numeroEscale;
    private String consignataire;
    private LocalDate dateNavire;
    private String etat;

    @OneToMany(mappedBy = "navir")
    private List<MouvementEntity> mouvements;

    @OneToMany(mappedBy = "navire")
    private List<EscaleEntity> escales;

}
