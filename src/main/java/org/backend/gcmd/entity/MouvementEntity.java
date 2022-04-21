package org.backend.gcmd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Table(name = "Gcmd_mouvement")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MouvementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private LocalDate dateMouvement;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "navir_id", nullable = false)
    private NavireEntity navir;

    @Column(name = "navir_id", insertable = false, updatable = false)
    private Long navirId;
}
