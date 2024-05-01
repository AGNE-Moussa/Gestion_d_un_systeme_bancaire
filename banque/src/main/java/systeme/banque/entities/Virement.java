package systeme.banque.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.Instant;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "virements")
public class Virement {
    @Id
    private Long idVirement ;
    @Column(nullable = false)
    private Double montant;
    @Column(length = 100 , nullable = false)
    private String libelleVirement;
    @Column(nullable = false)
    private Instant dateCreation ;
    @ManyToOne
    private  Compte CompteEmmetteur;
    @ManyToOne
    private Compte CompteBeneficiare;


}
