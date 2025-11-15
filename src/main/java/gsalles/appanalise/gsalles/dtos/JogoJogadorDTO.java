package gsalles.appanalise.gsalles.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JogoJogadorDTO {

    private Long jogoId;

    private Long jogadorId;

    private LocalDate data;
    

    private String status;
    
    private boolean cartaoVermelho;
    private boolean cartaoAmarelo;

    private Integer minutosJogados;
    
    private Double notaGeral;
    
    private List<DesempenhoCriterioJogoJogadorDTO> desempenhos = new ArrayList<>();
    private List<DesempenhoCriterioDiretoJogoJogadorDTO> desempenhosDiretos = new ArrayList<>();
}
