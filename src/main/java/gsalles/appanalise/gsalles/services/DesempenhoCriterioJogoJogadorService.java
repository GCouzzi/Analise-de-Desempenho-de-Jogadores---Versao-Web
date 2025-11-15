package gsalles.appanalise.gsalles.services;

import gsalles.appanalise.gsalles.dtos.DesempenhoCriterioJogoJogadorDTO;
import gsalles.appanalise.gsalles.entities.Criterio;
import gsalles.appanalise.gsalles.entities.DesempenhoCriterioJogoJogador;
import gsalles.appanalise.gsalles.entities.JogoJogador;
import gsalles.appanalise.gsalles.repository.CriterioRepository;
import gsalles.appanalise.gsalles.repository.DesempenhoCriterioJogoJogadorRepository;
import gsalles.appanalise.gsalles.repository.JogoJogadorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DesempenhoCriterioJogoJogadorService {

    @Autowired
    private DesempenhoCriterioJogoJogadorRepository repository;

    @Autowired
    private JogoJogadorRepository jogoJogadorRepository;

    @Autowired
    private CriterioRepository criterioRepository;

    public List<DesempenhoCriterioJogoJogadorDTO> findAll() {
        return repository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public DesempenhoCriterioJogoJogadorDTO findById(Long id) {
        return toDto(findEntityById(id));
    }

    @Transactional
    public DesempenhoCriterioJogoJogadorDTO create(DesempenhoCriterioJogoJogadorDTO dto) {
        DesempenhoCriterioJogoJogador entity = new DesempenhoCriterioJogoJogador();
        return toDto(save(entity, dto));
    }

    @Transactional
    public DesempenhoCriterioJogoJogadorDTO update(Long id, DesempenhoCriterioJogoJogadorDTO dto) {
        DesempenhoCriterioJogoJogador entity = findEntityById(id);
        return toDto(save(entity, dto));
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private DesempenhoCriterioJogoJogador save(DesempenhoCriterioJogoJogador entity,
                                               DesempenhoCriterioJogoJogadorDTO dto) {
        JogoJogador jogoJogador = jogoJogadorRepository.findById(dto.getJogoJogadorId())
                .orElseThrow(() -> new EntityNotFoundException("JogoJogador não encontrado com ID: " + dto.getJogoJogadorId()));

        Criterio criterio = criterioRepository.findById(dto.getCriterioId())
                .orElseThrow(() -> new EntityNotFoundException("Critério não encontrado com ID: " + dto.getCriterioId()));

        entity.setJogoJogador(jogoJogador);
        entity.setCriterio(criterio);
        entity.setNumeroTentativas(dto.getTentativas());
        entity.setNumeroAcertos(dto.getAcertos());
        entity.setPeso(dto.getPeso());

        return repository.save(entity);
    }

    private DesempenhoCriterioJogoJogador findEntityById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Desempenho não encontrado com ID: " + id));
    }

    private DesempenhoCriterioJogoJogadorDTO toDto(DesempenhoCriterioJogoJogador entity) {
        DesempenhoCriterioJogoJogadorDTO dto = new DesempenhoCriterioJogoJogadorDTO();
        dto.setCriterioId(entity.getCriterio().getId());
        dto.setJogoJogadorId(entity.getJogoJogador().getId());
        dto.setTentativas(entity.getNumeroTentativas());
        dto.setAcertos(entity.getNumeroAcertos());
        dto.setPeso(entity.getPeso());
        return dto;
    }
}