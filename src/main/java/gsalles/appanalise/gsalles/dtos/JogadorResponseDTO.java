package gsalles.appanalise.gsalles.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class JogadorResponseDTO {

    private Long id;
    private String nome;

    private Integer idade;

    private String posicao;

    private Integer altura;

    private String pernaDominante;
}
