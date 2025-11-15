package gsalles.appanalise.gsalles.controllers;

import gsalles.appanalise.gsalles.dtos.CriterioDTO;
import gsalles.appanalise.gsalles.services.CriterioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/criterios")
public class CriterioController {

    @Autowired
    private CriterioService criterioService;

    @GetMapping
    public ResponseEntity<List<CriterioDTO>> findAll() {
        List<CriterioDTO> criterios = criterioService.findAll();
        return ResponseEntity.ok().body(criterios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CriterioDTO> findById(@PathVariable Long id) {
        CriterioDTO criterio = criterioService.findById(id);
        return ResponseEntity.ok().body(criterio);
    }

    @PostMapping
    public ResponseEntity<CriterioDTO> create(@RequestBody CriterioDTO dto) {
        CriterioDTO novoCriterio = criterioService.create(dto);
        
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand()
                .toUri();
                
        return ResponseEntity.created(uri).body(novoCriterio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CriterioDTO> update(
            @PathVariable Long id, 
            @RequestBody CriterioDTO dto) {
                
        CriterioDTO criterioAtualizado = criterioService.update(id, dto);
        return ResponseEntity.ok().body(criterioAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        criterioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
