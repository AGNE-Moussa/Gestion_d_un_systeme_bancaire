package systeme.banque.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import systeme.banque.entities.Client;
import systeme.banque.services.ClientService;
import java.util.List;
@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> getClients() {
        // Logique pour récupérer les clients en fonction des paramètres
        List<Client> clients = clientService.getClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }
    @GetMapping("/{idClient}")
    public ResponseEntity<Client> getClientById(@PathVariable Long idClient) {
        // Logique pour récupérer un client par son ID
        Client client = clientService.getClientById(idClient);

        if (client != null) {
            return new ResponseEntity<>(client, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        // Logique pour créer un nouveau client
        Client createdClient = clientService.createClient(client);
        return new ResponseEntity<>(createdClient, HttpStatus.CREATED);
    }
    @PutMapping("/{idClient}")
    public ResponseEntity<Client> updateClient(@PathVariable Long idClient, @RequestBody Client client) {
        // Logique pour mettre à jour un client
        Client updatedClient = clientService.updateClient(idClient, client);
        return new ResponseEntity<>(updatedClient, HttpStatus.OK);
    }
}
