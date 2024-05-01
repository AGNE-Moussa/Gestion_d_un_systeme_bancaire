package systeme.banque.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import systeme.banque.entities.Client;
import systeme.banque.repositories.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getClients() {
        // Logique pour récupérer les clients en fonction des paramètres
        return clientRepository.findAll();
    }
    public Client getClientById(Long id) {
        // Logique pour récupérer un client par son ID
        Optional<Client> clientOptional = clientRepository.findById(id);

        return clientOptional.orElse(null);
    }
    public Client createClient(Client client) {
        // Logique pour créer un nouveau client
        return clientRepository.save(client);
    }

    public Client updateClient(Long idClient, Client updatedClient) {
        // Logique pour mettre à jour un client
        Optional<Client> existingClientOptional = clientRepository.findById(idClient);

        if (existingClientOptional.isPresent()) {
            Client existingClient = existingClientOptional.get();
            // Mettez à jour les champs du client existant avec les nouvelles valeurs
            existingClient.setPrenom(updatedClient.getPrenom());
            existingClient.setNom(updatedClient.getNom());
            return clientRepository.save(existingClient);
        } else {
            //  Le cas où le client n'est pas trouvé
            return null;
        }
    }
}

