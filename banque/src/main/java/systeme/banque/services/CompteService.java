package systeme.banque.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import systeme.banque.entities.Carte;
import systeme.banque.entities.Compte;
import systeme.banque.repositories.CompteRepository;

import java.util.List;
@Service
public class CompteService {
    @Autowired
    private CompteRepository compteRepository;
    public List<Compte> getAllComptes() {
        return compteRepository.findAll();
    }
    public Compte createCompte(Compte compte) {
        // Logique pour créer un nouveau compte
        return compteRepository.save(compte);
    }
    public List<Carte> getCartesByIban(String iban) {
        // Logique pour récupérer les cartes par IBAN
        Compte compte = compteRepository.findById(iban).orElseThrow(() -> new RuntimeException("Compte non trouvé"));
        if (compte != null) {
            return compte.getCartes();
        } else {
            // Le cas où le compte n'est pas trouvé
            return null;
        }
    }
    public Compte createCompteWithCarte(String iban, CarteRequest carteRequest) {
        Compte compte = compteRepository.findById(iban).orElse(null);
        if (compte != null) {
            Carte nouvelleCarte = new Carte();
            nouvelleCarte.setNumeroCarte(carteRequest.getNumeroCarte());
            nouvelleCarte.setDateExpiration(carteRequest.getDateExpiration());
            nouvelleCarte.setCode(carteRequest.getCode());

            compte.addCarte(nouvelleCarte);
            return compteRepository.save(compte);
        } else {
            return null;
        }
    }
    public String effectuerPaiement(String iban, Long numeroCarte) {
        // Logique pour effectuer un paiement depuis une carte
        Compte compte = compteRepository.findById(iban).orElse(null);
        if (compte != null) {
            Carte carte = compte.getCarteByNumero(numeroCarte);
            if (carte != null) {
                // Logique pour effectuer le paiement
                return "Paiement effectué avec succès";
            } else {
                //Le cas où la carte n'est pas trouvée
                return "Carte non trouvée";
            }
        } else {
            // Le cas où le compte n'est pas trouvé
            return "Compte non trouvé";
        }
    }
}
