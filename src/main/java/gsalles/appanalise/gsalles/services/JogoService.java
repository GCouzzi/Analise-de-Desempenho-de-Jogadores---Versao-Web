package gsalles.appanalise.gsalles.services;

import gsalles.appanalise.gsalles.dtos.JogoDTO;
import gsalles.appanalise.gsalles.dtos.mappers.JogoMapper;
import gsalles.appanalise.gsalles.entities.Campeonato;
import gsalles.appanalise.gsalles.entities.Jogo;
import gsalles.appanalise.gsalles.repository.CampeonatoRepository;
import gsalles.appanalise.gsalles.repository.JogoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JogoService {
    @Autowired
    private JogoRepository jogoRepository;
    
    @Autowired
    private CampeonatoService campeonatoService;

    @Transactional(readOnly = true)
    public List<Jogo> findAll() {
        return jogoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Jogo findById(Long id) {
        return jogoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Jogo não encontrado com o ID: " + id));
    }

    @Transactional
    public Jogo create(JogoDTO dto) {
        Jogo jogo = JogoMapper.toEntity(dto);
        jogo.setCampeonato(campeonatoService.findById(jogo.getCampeonato().getId()));
        return jogoRepository.save(jogo);
    }

    @Transactional
    public Jogo update(Long id, JogoDTO dto) {
        Jogo jogo = jogoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Jogo não encontrado com o ID: " + id));

        if (dto.getCampeonatoId() != null && !dto.getCampeonatoId().equals(jogo.getCampeonato().getId())) {
            Campeonato campeonato = campeonatoService.findById(dto.getCampeonatoId());
            jogo.setCampeonato(campeonato);
        }

        jogo.setAdversario(dto.getAdversario());
        jogo.setDificuldade(dto.getDificuldade());
        jogo.setGolsMarcados(dto.getGolsMarcados());
        jogo.setGolsSofridos(dto.getGolsSofridos());

        return jogoRepository.save(jogo);
    }

    @Transactional
    public void delete(Long id) {
        Jogo jogo = jogoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Jogo não encontrado com o ID: " + id));
        jogoRepository.delete(jogo);
    }
}
