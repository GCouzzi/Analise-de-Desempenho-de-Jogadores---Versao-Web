package gsalles.appanalise.gsalles.controllers;

import gsalles.appanalise.gsalles.dtos.JogadorDTO;
import gsalles.appanalise.gsalles.dtos.JogadorResponseDTO;
import gsalles.appanalise.gsalles.dtos.mappers.JogadorMapper;
import gsalles.appanalise.gsalles.entities.Jogador;
import gsalles.appanalise.gsalles.services.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jogadores")
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;

    @GetMapping
    public ResponseEntity<List<JogadorResponseDTO>> findAll() {
        List<Jogador> jogadores = jogadorService.findAll();
        return ResponseEntity.ok().body(JogadorMapper.toListDTO(jogadores));
    }

    @GetMapping("/{id}")
    public ResponseEntity<JogadorResponseDTO> findById(@PathVariable Long id) {
        Jogador jogador = jogadorService.findById(id);
        return ResponseEntity.ok().body(JogadorMapper.toDTO(jogador));
    }

    @PostMapping
    public ResponseEntity<JogadorResponseDTO> create(@RequestBody JogadorDTO dto) {
        Jogador novoJogador = jogadorService.create(dto);
        return ResponseEntity.status(201).body(JogadorMapper.toDTO(novoJogador));
    }

    @PutMapping("/{id}")
    public ResponseEntity<JogadorResponseDTO> update(
            @PathVariable Long id, 
            @RequestBody JogadorDTO dto) {
        Jogador jogadorAtualizado = jogadorService.update(id, dto);
        return ResponseEntity.ok().body(JogadorMapper.toDTO(jogadorAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        jogadorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
