package gsalles.appanalise.gsalles.controllers;

import gsalles.appanalise.gsalles.dtos.DesempenhoCriterioDiretoJogoJogadorDTO;
import gsalles.appanalise.gsalles.services.DesempenhoCriterioDiretoJogoJogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/desempenhos-criterio-direto")
public class DesempenhoCriterioDiretoJogoJogadorController {

    @Autowired
    private DesempenhoCriterioDiretoJogoJogadorService service;

    @GetMapping
    public ResponseEntity<List<DesempenhoCriterioDiretoJogoJogadorDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DesempenhoCriterioDiretoJogoJogadorDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<DesempenhoCriterioDiretoJogoJogadorDTO> create(
            @RequestBody DesempenhoCriterioDiretoJogoJogadorDTO dto) {

        DesempenhoCriterioDiretoJogoJogadorDTO created = service.create(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand()
                .toUri();

        return ResponseEntity.created(uri).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DesempenhoCriterioDiretoJogoJogadorDTO> update(
            @PathVariable Long id,
            @RequestBody DesempenhoCriterioDiretoJogoJogadorDTO dto) {

        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}