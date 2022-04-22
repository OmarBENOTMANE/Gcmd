package org.backend.gcmd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "devis")
    private List<DevisEntity> devis;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_client_id", nullable = false,insertable = false,updatable = false)
    private TypeClientEntity typeClient;

    @Column(name = "type_client_id")
    private Long typeClientId;
}
