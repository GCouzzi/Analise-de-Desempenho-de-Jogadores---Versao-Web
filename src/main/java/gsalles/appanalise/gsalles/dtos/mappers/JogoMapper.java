package gsalles.appanalise.gsalles.dtos.mappers;

import gsalles.appanalise.gsalles.dtos.JogoDTO;
import gsalles.appanalise.gsalles.dtos.JogoResponseDTO;
import gsalles.appanalise.gsalles.entities.Jogo;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.List;
import java.util.stream.Collectors;

public class JogoMapper {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    static {
        MODEL_MAPPER.typeMap(JogoDTO.class, Jogo.class).addMappings(mapper -> {
            mapper.skip(Jogo::setId); // Nunca mapeia o ID
        });
    }

    public static JogoResponseDTO toDTO(Jogo jogo){
        return MODEL_MAPPER.map(jogo, JogoResponseDTO.class);
    }

    public static Jogo toEntity(JogoDTO dto){
        return MODEL_MAPPER.map(dto, Jogo.class);
    }

    public static List<JogoResponseDTO> toListDTO(List<Jogo> jogos){
        return jogos.stream().map(JogoMapper::toDTO).collect(Collectors.toList());
    }
}
