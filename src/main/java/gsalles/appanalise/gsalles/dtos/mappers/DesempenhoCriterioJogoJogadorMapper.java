package gsalles.appanalise.gsalles.dtos.mappers;

import gsalles.appanalise.gsalles.dtos.DesempenhoCriterioJogoJogadorDTO;
import gsalles.appanalise.gsalles.dtos.DesempenhoCriterioJogoJogadorResponseDTO;
import gsalles.appanalise.gsalles.entities.DesempenhoCriterioJogoJogador;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class DesempenhoCriterioJogoJogadorMapper {

    private final static ModelMapper MODEL_MAPPER = new ModelMapper();

    public static DesempenhoCriterioJogoJogadorResponseDTO toDTO(DesempenhoCriterioJogoJogador entity) {
        return MODEL_MAPPER.map(entity, DesempenhoCriterioJogoJogadorResponseDTO.class);
    }

    public static DesempenhoCriterioJogoJogador toEntity(DesempenhoCriterioJogoJogadorDTO dto) {
        return MODEL_MAPPER.map(dto, DesempenhoCriterioJogoJogador.class);
    }

    public static List<DesempenhoCriterioJogoJogadorResponseDTO> toListDTO(List<DesempenhoCriterioJogoJogador> entities) {
        return entities.stream()
                .map(DesempenhoCriterioJogoJogadorMapper::toDTO)
                .collect(Collectors.toList());
    }
}
