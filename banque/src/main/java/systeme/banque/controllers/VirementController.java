package systeme.banque.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import systeme.banque.services.VirementRequest;
import systeme.banque.services.VirementService;
@RestController
@RequestMapping("/virements")
public class VirementController {
    @Autowired
    private VirementService virementService;
    @PostMapping
    public ResponseEntity<String> createVirement(@RequestBody VirementRequest virementRequest) {
        String resultatVirement = virementService.effectuerVirement(
                virementRequest.getIbanEmetteur(),
                virementRequest.getIbanBeneficiaire(),
                virementRequest.getMontant(),
                virementRequest.getLibelleVirement()
        );
        if (resultatVirement.equals("Virement effectué avec succès")) {
            return new ResponseEntity<>(resultatVirement, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(resultatVirement, HttpStatus.BAD_REQUEST);
        }
    }

}
