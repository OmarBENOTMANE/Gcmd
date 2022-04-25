package org.backend.gcmd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Table(name = "Gcmd_escale")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EscaleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numeroEscale;

    @Column(name = "navire_id", nullable = false, insertable = false, updatable = false)
    private Long navireId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "navire_id")
    private NavireEntity navire;

    @OneToMany(mappedBy = "escale",fetch = FetchType.LAZY)
    private List<MarchandiseEntity> marchandiseList;

    @OneToMany(mappedBy = "escale",fetch = FetchType.LAZY)
    private List<DevisEntity> devisList;

    @OneToMany(mappedBy = "escale",fetch = FetchType.LAZY)
    private List<CommandeEntity> CommandeList;
}
