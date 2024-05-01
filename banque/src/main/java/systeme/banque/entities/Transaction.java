package systeme.banque.entities;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    private Long idTransaction;
    @Column(nullable = false)
    private Double montant;
    @Column(length = 100, nullable = false)
    private String typeTransaction;
    @Column(nullable = false)
    private Instant dateCreation;
    @Column(length = 100, nullable = false)
    private String typeSource;
    @Column(nullable = false)
    private Long idSource;

    @ManyToOne
    @JoinColumn(name = "iban")
    private Compte compte;
}
