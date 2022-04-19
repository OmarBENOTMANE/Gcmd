package org.backend.gcmd.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

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

    private Date dateMouvement;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "navir_id", nullable = false)
    private NavireEntity navir;

    @Column(name = "navir_id")
    private Long navirId;
}
