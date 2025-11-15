package gsalles.appanalise.gsalles.dtos.mappers;

import gsalles.appanalise.gsalles.dtos.CriterioDTO;
import gsalles.appanalise.gsalles.dtos.CriterioResponseDTO;
import gsalles.appanalise.gsalles.entities.Criterio;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class CriterioMapper {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public static Criterio toEntity(CriterioDTO dto) {
        return MODEL_MAPPER.map(dto, Criterio.class);
    }

    public static CriterioResponseDTO toDTO(Criterio criterio) {
        return MODEL_MAPPER.map(criterio, CriterioResponseDTO.class);
    }

    public static List<CriterioResponseDTO> toListDTO(List<Criterio> criterios) {
        return criterios.stream().map(CriterioMapper::toDTO).collect(Collectors.toList());
    }
}
