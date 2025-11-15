package gsalles.appanalise.gsalles.dtos.mappers;

import gsalles.appanalise.gsalles.dtos.CampeonatoDTO;
import gsalles.appanalise.gsalles.dtos.CampeonatoResponseDTO;
import gsalles.appanalise.gsalles.entities.Campeonato;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class CampeonatoMapper {

    public static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public static CampeonatoResponseDTO toDTO(Campeonato campeonato){
        return MODEL_MAPPER.map(campeonato, CampeonatoResponseDTO.class);
    }

    public static Campeonato toEntity(CampeonatoDTO dto){
        return MODEL_MAPPER.map(dto, Campeonato.class);
    }

    public static List<CampeonatoResponseDTO> toListDTO(List<Campeonato> campeonatos){
        return campeonatos.stream().map(CampeonatoMapper::toDTO).collect(Collectors.toList());
    }
}
