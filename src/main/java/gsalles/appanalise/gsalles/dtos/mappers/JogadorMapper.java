package gsalles.appanalise.gsalles.dtos.mappers;

import gsalles.appanalise.gsalles.dtos.JogadorDTO;
import gsalles.appanalise.gsalles.dtos.JogadorResponseDTO;
import gsalles.appanalise.gsalles.entities.Jogador;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class JogadorMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static Jogador toEntity(JogadorDTO dto) {
        return modelMapper.map(dto, Jogador.class);
    }

    public static JogadorResponseDTO toDTO(Jogador jogador) {
        return modelMapper.map(jogador, JogadorResponseDTO.class);
    }

    public static List<JogadorResponseDTO> toListDTO(List<Jogador> jogadores) {
        return jogadores.stream().map(JogadorMapper::toDTO).collect(Collectors.toList());
    }
}
