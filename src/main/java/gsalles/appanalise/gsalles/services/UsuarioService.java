package gsalles.appanalise.gsalles.services;

import gsalles.appanalise.gsalles.dtos.UsuarioDTO;
import gsalles.appanalise.gsalles.dtos.mappers.UsuarioMapper;
import gsalles.appanalise.gsalles.entities.Usuario;
import gsalles.appanalise.gsalles.repository.UsuarioRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com o ID: " + id));
    }

    @Transactional
    public Usuario create(UsuarioDTO dto) {
        // Verifica se já existe um usuário com o mesmo email
        if (usuarioRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new EntityExistsException("Já existe um usuário com o email: " + dto.getEmail());
        }

        return usuarioRepository.save(UsuarioMapper.toEntity(dto));
    }

}
