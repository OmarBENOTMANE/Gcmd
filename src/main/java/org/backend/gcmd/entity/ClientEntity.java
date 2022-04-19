package org.backend.gcmd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Table(name = "Gcmd_client")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String phone;

    @Column(name = "client_id")
    private Long clientId;

    @OneToMany(mappedBy = "devis")
    private List<DevisEntity> devis;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private TypeClientEntity client;
}
