package gsalles.appanalise.gsalles.services;

import gsalles.appanalise.gsalles.dtos.DesempenhoCriterioJogoJogadorDTO;
import gsalles.appanalise.gsalles.entities.Criterio;
import gsalles.appanalise.gsalles.entities.DesempenhoCriterioJogoJogador;
import gsalles.appanalise.gsalles.entities.JogoJogador;
import gsalles.appanalise.gsalles.repository.CriterioRepository;
import gsalles.appanalise.gsalles.repository.DesempenhoCriterioJogoJogadorRepository;
import gsalles.appanalise.gsalles.repository.JogoJogadorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DesempenhoCriterioJogoJogadorService {

    private final DesempenhoCriterioJogoJogadorRepository repository;

    private final JogoJogadorRepository jogoJogadorRepository;

    private final CriterioRepository criterioRepository;

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

    @Transactional(readOnly = true)
    private List<DesempenhoCriterioJogoJogador> findByJogoJogadorId(Long id) {
        return repository.findByJogoJogadorId(id);
    }

}