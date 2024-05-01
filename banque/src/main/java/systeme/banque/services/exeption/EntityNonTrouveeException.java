package systeme.banque.services.exeption;

public class EntityNonTrouveeException extends RuntimeException {
    public EntityNonTrouveeException(String message) {
        super(message);
    }
}
