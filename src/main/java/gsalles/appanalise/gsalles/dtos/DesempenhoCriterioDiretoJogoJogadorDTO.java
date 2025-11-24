package gsalles.appanalise.gsalles.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DesempenhoCriterioDiretoJogoJogadorDTO {

    private Long criterioId;
    private Integer ocorrencias;
    private Integer peso;
}
