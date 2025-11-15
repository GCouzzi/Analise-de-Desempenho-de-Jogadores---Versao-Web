package gsalles.appanalise.gsalles.controllers;

import gsalles.appanalise.gsalles.dtos.DesempenhoCriterioJogoJogadorDTO;
import gsalles.appanalise.gsalles.services.DesempenhoCriterioJogoJogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/desempenhos-criterio")
public class DesempenhoCriterioJogoJogadorController {

    @Autowired
    private DesempenhoCriterioJogoJogadorService service;

    @GetMapping
    public ResponseEntity<List<DesempenhoCriterioJogoJogadorDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DesempenhoCriterioJogoJogadorDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<DesempenhoCriterioJogoJogadorDTO> create(
            @RequestBody DesempenhoCriterioJogoJogadorDTO dto) {

        DesempenhoCriterioJogoJogadorDTO created = service.create(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand()
                .toUri();

        return ResponseEntity.created(uri).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DesempenhoCriterioJogoJogadorDTO> update(
            @PathVariable Long id,
            @RequestBody DesempenhoCriterioJogoJogadorDTO dto) {

        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}