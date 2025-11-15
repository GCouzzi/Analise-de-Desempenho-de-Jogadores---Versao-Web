package gsalles.appanalise.gsalles.controllers;

import gsalles.appanalise.gsalles.dtos.UsuarioDTO;
import gsalles.appanalise.gsalles.dtos.UsuarioResponseDTO;
import gsalles.appanalise.gsalles.dtos.mappers.UsuarioMapper;
import gsalles.appanalise.gsalles.entities.Usuario;
import gsalles.appanalise.gsalles.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> findAll() {
        List<UsuarioResponseDTO> usuarios = UsuarioMapper.toListDTO(usuarioService.findAll());
        return ResponseEntity.ok().body(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(UsuarioMapper.toDTO(usuarioService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> create(@RequestBody UsuarioDTO dto) {
        Usuario novoUsuario = usuarioService.create(dto);

        return ResponseEntity.status(201).body(UsuarioMapper.toDTO(novoUsuario));
    }

}
