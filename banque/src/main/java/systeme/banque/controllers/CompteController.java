package systeme.banque.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import systeme.banque.entities.Carte;
import systeme.banque.entities.Compte;
import systeme.banque.services.CarteRequest;
import systeme.banque.services.CompteService;
import java.util.List;

@RestController
@RequestMapping("/comptes")
public class CompteController {
    @Autowired
    private CompteService compteService;
    @GetMapping
    public ResponseEntity<List<Compte>> getComptes() {
        List<Compte> comptes = compteService.getAllComptes();
        return new ResponseEntity<>(comptes, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Compte> createCompte(@RequestBody Compte compte) {
        Compte createdCompte = compteService.createCompte(compte);
        return new ResponseEntity<>(createdCompte, HttpStatus.CREATED);
    }
    @GetMapping("/{iban}/cartes")
    public ResponseEntity<List<Carte>> getCartesByIban(@PathVariable String iban) {
        List<Carte> cartes = compteService.getCartesByIban(iban);
        return new ResponseEntity<>(cartes, HttpStatus.OK);
    }
    @PostMapping("/{iban}/cartes")
    public ResponseEntity<Compte> createCompteWithCarte(@PathVariable String iban, @RequestBody CarteRequest carteRequest) {
        Compte compte = compteService.createCompteWithCarte(iban, carteRequest);
        if (compte != null) {
            return new ResponseEntity<>(compte, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/{iban}/cartes/{numeroCarte}/paiement")
    public ResponseEntity<String> effectuerPaiement(@PathVariable String iban, @PathVariable Long numeroCarte) {
        String resultatPaiement = compteService.effectuerPaiement(iban, numeroCarte);
        if (resultatPaiement.equals("Paiement effectué avec succès")) {
            return new ResponseEntity<>(resultatPaiement, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(resultatPaiement, HttpStatus.NOT_FOUND);
        }
    }

}
