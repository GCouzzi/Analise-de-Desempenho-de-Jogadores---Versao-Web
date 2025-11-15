package gsalles.appanalise.gsalles.controllers;

import gsalles.appanalise.gsalles.dtos.JogoJogadorDTO;
import gsalles.appanalise.gsalles.entities.JogoJogador;
import gsalles.appanalise.gsalles.services.JogoJogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/jogos-jogadores")
public class JogoJogadorController {

    @Autowired
    private JogoJogadorService jogoJogadorService;

    @GetMapping
    public ResponseEntity<List<JogoJogadorDTO>> findAll() {
        List<JogoJogador> jogosJogadores = jogoJogadorService.findAll();
        List<JogoJogadorDTO> dtos = jogosJogadores.stream()
                .map(jogoJogadorService::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JogoJogadorDTO> findById(@PathVariable Long id) {
        JogoJogador jogoJogador = jogoJogadorService.findById(id);
        return ResponseEntity.ok().body(jogoJogadorService.toDto(jogoJogador));
    }

//    @PostMapping
//    public ResponseEntity<JogoJogadorDTO> create(@RequestBody JogoJogadorDTO dto) {
//        JogoJogador jogoJogador = jogoJogadorService.create(dto);
//        JogoJogadorDTO responseDto = jogoJogadorService.toDto(jogoJogador);
//
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand()
//                .toUri();
//
//        return ResponseEntity.created(uri).body(responseDto);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<JogoJogadorDTO> update(
            @PathVariable Long id, 
            @RequestBody JogoJogadorDTO dto) {
        
        JogoJogador jogoAtualizado = jogoJogadorService.update(id, dto);
        return ResponseEntity.ok().body(jogoJogadorService.toDto(jogoAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        jogoJogadorService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    // Endpoints adicionais específicos para JogoJogador
    
    @GetMapping("/jogo/{jogoId}")
    public ResponseEntity<List<JogoJogadorDTO>> findByJogoId(@PathVariable Long jogoId) {
        List<JogoJogador> jogosJogadores = jogoJogadorService.findByJogoId(jogoId);
        List<JogoJogadorDTO> dtos = jogosJogadores.stream()
                .map(jogoJogadorService::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(dtos);
    }
    
    @GetMapping("/jogador/{jogadorId}")
    public ResponseEntity<List<JogoJogadorDTO>> findByJogadorId(@PathVariable Long jogadorId) {
        List<JogoJogador> jogosJogadores = jogoJogadorService.findByJogadorId(jogadorId);
        List<JogoJogadorDTO> dtos = jogosJogadores.stream()
                .map(jogoJogadorService::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(dtos);
    }
}
