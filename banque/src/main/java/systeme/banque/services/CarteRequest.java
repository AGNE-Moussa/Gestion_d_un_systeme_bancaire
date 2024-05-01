package systeme.banque.services;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarteRequest {
    private Long numeroCarte;
    private Instant dateExpiration;
    private Integer code;
    /*
    public CarteRequest(Long numeroCarte, Instant dateExpiration, Integer code) {
        this.numeroCarte = numeroCarte;
        this.dateExpiration = dateExpiration;
        this.code = code;
    }
    */

}
