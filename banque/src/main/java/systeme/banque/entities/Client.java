package systeme.banque.entities;
import jakarta.persistence.*;

import lombok.*;


import java.util.List;
import java.time.Instant;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient ;
    @Column(length = 100, nullable = false)
    private String prenom;
    @Column(length = 100, nullable = false)
    private String nom;

    @Column(name ="DATENAISSANCE")
    private Instant dateNaissance;
    @Column(length = 15, nullable = false)
    private int telephone;
    @Column(name = "ADRESSEPOSTALE")

    private String adressePostale;
    @Column(name = "DATECREATION")

    private Instant dateCreation;
    @JoinTable(name = "titulairesCompte",
            joinColumns =
                @JoinColumn(name = "idClient", referencedColumnName = "idClient"),
            inverseJoinColumns =
                @JoinColumn(name = "iban", referencedColumnName = "iban")
    )
    @ManyToMany
    private List<Compte> comptes;


}
