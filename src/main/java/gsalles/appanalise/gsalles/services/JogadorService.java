package gsalles.appanalise.gsalles.services;

import gsalles.appanalise.gsalles.dtos.JogadorDTO;
import gsalles.appanalise.gsalles.dtos.mappers.JogadorMapper;
import gsalles.appanalise.gsalles.entities.Jogador;
import gsalles.appanalise.gsalles.repository.JogadorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JogadorService {
    @Autowired
    private JogadorRepository jogadorRepository;

    @Transactional(readOnly = true)
    public List<Jogador> findAll() {
        return jogadorRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Jogador findById(Long id) {
        Jogador jogador = jogadorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Jogador não encontrado com o ID: " + id));
        return jogador;
    }

    @Transactional
    public Jogador create(JogadorDTO dto) {
        return jogadorRepository.save(JogadorMapper.toEntity(dto));
    }

    @Transactional
    public Jogador update(Long id, JogadorDTO dto) {
        Jogador jogador = jogadorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Jogador não encontrado com o ID: " + id));
                
        jogador.setNome(dto.getNome());
        jogador.setIdade(dto.getIdade());
        jogador.setPosicao(dto.getPosicao());
        jogador.setAltura(dto.getAltura());
        jogador.setPernaDominante(Jogador.PernaDominante.valueOf(dto.getPernaDominante()));

        return jogadorRepository.save(jogador);
    }

    @Transactional
    public void delete(Long id) {
        Jogador jogador = jogadorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Jogador não encontrado com o ID: " + id));
        jogadorRepository.delete(jogador);
    }

}
