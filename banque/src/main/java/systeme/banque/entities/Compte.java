package systeme.banque.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "comptes")
public class Compte {
    @Id
    private String iban ; //International Bank Account Number
    @Column(nullable = false)
    private Double solde;
    @Column(length = 100, nullable = false)
    private String intituleCompte;
    @Column(length = 100, nullable = false)
    private String typeCompte;
    @Column(length = 100, nullable = false)
    private String titulairesCompte;
    @Column(nullable = false)
    private Instant dateCreation;
    @ManyToMany(mappedBy = "comptes")
    private List<Client> titulaires;
    @OneToMany(mappedBy = "compte")
    private List<Carte> cartes;
    @OneToMany(mappedBy = "compte")
    private List<Transaction> transactions;

    public void addCarte(Carte nouvelleCarte) {
        if (cartes == null) {
            cartes = new ArrayList<>();
        }
        cartes.add(nouvelleCarte);
    }

    public Carte getCarteByNumero(Long numeroCarte) {
        return cartes.stream()
                .filter(carte -> carte.getNumeroCarte().equals(numeroCarte))
                .findFirst()
                .orElse(null);
    }
    public List<Carte> getCartes() {
        return cartes;
    }

}
