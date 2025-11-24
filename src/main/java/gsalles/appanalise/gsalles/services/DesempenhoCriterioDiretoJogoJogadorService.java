package gsalles.appanalise.gsalles.services;

import gsalles.appanalise.gsalles.dtos.DesempenhoCriterioDiretoJogoJogadorDTO;
import gsalles.appanalise.gsalles.dtos.mappers.DesempenhoCriterioDiretoJogoJogadorMapper;
import gsalles.appanalise.gsalles.entities.Criterio;
import gsalles.appanalise.gsalles.entities.DesempenhoCriterioDiretoJogoJogador;
import gsalles.appanalise.gsalles.entities.JogoJogador;
import gsalles.appanalise.gsalles.repository.DesempenhoCriterioDiretoJogoJogadorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DesempenhoCriterioDiretoJogoJogadorService {

    private final DesempenhoCriterioDiretoJogoJogadorRepository repository;

    private final JogoJogadorService jogoJogadorService;

    private final CriterioService criterioService;

    @Transactional(readOnly = true)
    public List<DesempenhoCriterioDiretoJogoJogador> findByJogoJogadorId(Long id) {
        return repository.findByJogoJogadorId(id);
    }

    @Transactional
    private DesempenhoCriterioDiretoJogoJogador create(
            DesempenhoCriterioDiretoJogoJogadorDTO dto) {

        DesempenhoCriterioDiretoJogoJogador obj = DesempenhoCriterioDiretoJogoJogadorMapper.toEntity(dto);
        obj.setCriterio(criterioService.findById(obj.getCriterio().getId()));
        obj.setJogoJogador(jogoJogadorService.findById(obj.getJogoJogador().getId()));
        obj.setOcorrencias(dto.getOcorrencias());
        obj.setPeso(dto.getPeso());

        return repository.save(obj);
    }

}