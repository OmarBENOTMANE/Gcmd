package org.backend.gcmd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "Gcmd_marchandise")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MarchandiseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Designation;
    private String reference;
    private double quantite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "escale_id", nullable = false)
    private EscaleEntity escale;

    @Column(name = "escale_id")
    private Long escaleId;
}
