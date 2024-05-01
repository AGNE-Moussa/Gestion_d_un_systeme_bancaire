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
@Table(name = "cartes")
public class Carte {
    @Id
    private Long numeroCarte;
    @Column(nullable = false) @NotBlank
    private Instant dateExpiration;
    @Column(length = 4,nullable = false)
    private Integer code;
    @ManyToOne
    @JoinColumn(name = "iban")
    private Compte compte;
    public Long getNumeroCarte() {
        return numeroCarte;
    }
}
