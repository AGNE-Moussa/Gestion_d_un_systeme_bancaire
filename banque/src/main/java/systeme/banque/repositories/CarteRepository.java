package systeme.banque.repositories;
import systeme.banque.entities.Carte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarteRepository extends JpaRepository<Carte,Long> {
}
