package gsalles.appanalise.gsalles.controllers;

import gsalles.appanalise.gsalles.dtos.JogoDTO;
import gsalles.appanalise.gsalles.dtos.JogoResponseDTO;
import gsalles.appanalise.gsalles.dtos.mappers.JogoMapper;
import gsalles.appanalise.gsalles.services.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/jogos")
public class JogoController {

    @Autowired
    private JogoService jogoService;

    @GetMapping
    public ResponseEntity<List<JogoResponseDTO>> findAll() {
        return ResponseEntity.ok(JogoMapper.toListDTO(jogoService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<JogoResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(JogoMapper.toDTO(jogoService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<JogoResponseDTO> create(@RequestBody JogoDTO dto) {
        return ResponseEntity.status(201).body(JogoMapper.toDTO(jogoService.create(dto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<JogoResponseDTO> update(
            @PathVariable Long id,
            @RequestBody JogoDTO dto) {
        return ResponseEntity.ok().body(JogoMapper.toDTO(jogoService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        jogoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
