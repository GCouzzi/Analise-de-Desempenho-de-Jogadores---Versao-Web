package gsalles.appanalise.gsalles.dtos.mappers;

import gsalles.appanalise.gsalles.dtos.DesempenhoCriterioDiretoJogoJogadorDTO;
import gsalles.appanalise.gsalles.dtos.DesempenhoCriterioDiretoJogoJogadorResponseDTO;
import gsalles.appanalise.gsalles.entities.DesempenhoCriterioDiretoJogoJogador;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class DesempenhoCriterioDiretoJogoJogadorMapper {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public static DesempenhoCriterioDiretoJogoJogador toEntity(DesempenhoCriterioDiretoJogoJogadorDTO dto) {
        return MODEL_MAPPER.map(dto, DesempenhoCriterioDiretoJogoJogador.class);
    }

    public static DesempenhoCriterioDiretoJogoJogadorResponseDTO toDTO(DesempenhoCriterioDiretoJogoJogador entity) {
        return MODEL_MAPPER.map(entity, DesempenhoCriterioDiretoJogoJogadorResponseDTO.class);
    }

    public static List<DesempenhoCriterioDiretoJogoJogadorResponseDTO> toListDTO(List<DesempenhoCriterioDiretoJogoJogador> entities) {
        return entities.stream()
                .map(DesempenhoCriterioDiretoJogoJogadorMapper::toDTO)
                .collect(Collectors.toList());
    }
}
