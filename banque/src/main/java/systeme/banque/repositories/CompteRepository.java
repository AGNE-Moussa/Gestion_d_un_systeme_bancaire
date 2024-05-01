package systeme.banque.repositories;
import systeme.banque.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompteRepository extends JpaRepository<Compte,String> {
    Optional<Compte> findByIban(String iban);
}
