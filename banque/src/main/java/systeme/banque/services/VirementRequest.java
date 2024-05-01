package systeme.banque.services;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VirementRequest {
    private String ibanEmetteur;
    private String ibanBeneficiaire;
    private Double montant;
    private String libelleVirement;

}
