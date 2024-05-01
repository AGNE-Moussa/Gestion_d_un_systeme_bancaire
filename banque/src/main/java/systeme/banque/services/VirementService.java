package systeme.banque.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import systeme.banque.entities.Compte;
import systeme.banque.entities.Virement;
import systeme.banque.repositories.CompteRepository;
import systeme.banque.repositories.VirementRepository;
import java.time.Instant;

@Service
public class VirementService {

    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private VirementRepository virementRepository;

    public String effectuerVirement(String ibanEmetteur, String ibanBeneficiaire, double montant, String libelleVirement) {
        Compte compteEmetteur = compteRepository.findById(ibanEmetteur)
                .orElseThrow(() -> new RuntimeException("Compte émetteur non trouvé"));

        Compte compteBeneficiaire = compteRepository.findById(ibanBeneficiaire)
                .orElseThrow(() -> new RuntimeException("Compte bénéficiaire non trouvé"));

        if (compteEmetteur.getSolde() >= montant) {
            // Mettez à jour le solde du compte émetteur
            compteEmetteur.setSolde(compteEmetteur.getSolde() - montant);
            compteRepository.save(compteEmetteur);

            // Mettez à jour le solde du compte bénéficiaire
            compteBeneficiaire.setSolde(compteBeneficiaire.getSolde() + montant);
            compteRepository.save(compteBeneficiaire);

            // Enregistrez le virement
            Virement virement = new Virement();
            virement.setMontant(montant);
            virement.setLibelleVirement(libelleVirement);
            virement.setDateCreation(Instant.now());
            virement.setCompteEmmetteur(compteEmetteur);
            virement.setCompteBeneficiare(compteBeneficiaire);
            virementRepository.save(virement);

            return "Virement effectué avec succès";
        } else {
            return "Solde insuffisant sur le compte émetteur";
        }
    }
}
