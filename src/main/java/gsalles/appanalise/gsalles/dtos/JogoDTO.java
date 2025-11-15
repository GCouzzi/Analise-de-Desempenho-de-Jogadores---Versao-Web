package gsalles.appanalise.gsalles.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class JogoDTO {

    private String adversario;
    private Integer dificuldade;
    private Integer golsMarcados;
    private Integer golsSofridos;
    private Long campeonatoId;
}
