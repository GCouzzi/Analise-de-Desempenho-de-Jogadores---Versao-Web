package gsalles.appanalise.gsalles.controllers;

import gsalles.appanalise.gsalles.dtos.CampeonatoDTO;
import gsalles.appanalise.gsalles.dtos.CampeonatoResponseDTO;
import gsalles.appanalise.gsalles.dtos.mappers.CampeonatoMapper;
import gsalles.appanalise.gsalles.entities.Campeonato;
import gsalles.appanalise.gsalles.services.CampeonatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/campeonatos")
public class CampeonatoController {

    @Autowired
    private CampeonatoService campeonatoService;

    @GetMapping
    public ResponseEntity<List<CampeonatoResponseDTO>> findAll() {
        return ResponseEntity.ok(CampeonatoMapper.toListDTO(campeonatoService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CampeonatoResponseDTO> findById(@PathVariable Long id) {
        Campeonato campeonato = campeonatoService.findById(id);
        return ResponseEntity.ok(CampeonatoMapper.toDTO(campeonato));
    }

    @PostMapping
    public ResponseEntity<CampeonatoResponseDTO> create(@RequestBody CampeonatoDTO dto) {
        Campeonato novoCampeonato = campeonatoService.create(dto);
        return ResponseEntity.status(201).body(CampeonatoMapper.toDTO(novoCampeonato));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CampeonatoResponseDTO> update(
            @PathVariable Long id, 
            @RequestBody CampeonatoDTO dto) {

        return ResponseEntity.ok().body(CampeonatoMapper.toDTO(campeonatoService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        campeonatoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
