package gsalles.appanalise.gsalles.dtos.mappers;

import gsalles.appanalise.gsalles.dtos.UsuarioDTO;
import gsalles.appanalise.gsalles.dtos.UsuarioResponseDTO;
import gsalles.appanalise.gsalles.entities.Usuario;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioMapper {


    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public static UsuarioResponseDTO toDTO(Usuario usuario) {
        return MODEL_MAPPER.map(usuario, UsuarioResponseDTO.class);
    }

    public static Usuario toEntity(UsuarioDTO usuarioDTO) {
        return MODEL_MAPPER.map(usuarioDTO, Usuario.class);
    }

    public static List<UsuarioResponseDTO> toListDTO(List<Usuario> usuarios){
        return usuarios.stream().map(UsuarioMapper::toDTO).collect(Collectors.toList());
    }
}
