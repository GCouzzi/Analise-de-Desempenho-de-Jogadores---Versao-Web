package gsalles.appanalise.gsalles.services;

import gsalles.appanalise.gsalles.dtos.DesempenhoCriterioJogoJogadorDTO;
import gsalles.appanalise.gsalles.dtos.DesempenhoCriterioDiretoJogoJogadorDTO;
import gsalles.appanalise.gsalles.dtos.JogoJogadorDTO;
import gsalles.appanalise.gsalles.entities.*;
import gsalles.appanalise.gsalles.repository.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JogoJogadorService {
    @Autowired
    private JogoJogadorRepository jogoJogadorRepository;
    
    @Autowired
    private JogoRepository jogoRepository;
    
    @Autowired
    private JogadorRepository jogadorRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private CriterioRepository criterioRepository;

    public List<JogoJogador> findAll() {
        return jogoJogadorRepository.findAll();
    }
    
    public List<JogoJogador> findByJogoId(Long jogoId) {
        return jogoJogadorRepository.findByJogoId(jogoId);
    }
    
    public List<JogoJogador> findByJogadorId(Long jogadorId) {
        return jogoJogadorRepository.findByJogadorId(jogadorId);
    }

    public JogoJogador findById(Long id) {
        return jogoJogadorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("JogoJogador não encontrado com o ID: " + id));
    }

//    @Transactional
//    public JogoJogador create(JogoJogadorDTO dto) {
//
//    }

    @Transactional
    public JogoJogador update(Long id, JogoJogadorDTO dto) {
        JogoJogador jogoJogador = findById(id);
        
        // Atualiza os campos básicos
        jogoJogador.setData(dto.getData());
        jogoJogador.setStatus(JogoJogador.StatusJogador.valueOf(dto.getStatus()));
        jogoJogador.setCartaoVermelho(dto.isCartaoVermelho());
        jogoJogador.setCartaoAmarelo(dto.isCartaoAmarelo());
        jogoJogador.setMinutosJogados(dto.getMinutosJogados());
        jogoJogador.setNotaGeral(dto.getNotaGeral());
        
        // Atualiza as entidades relacionadas se fornecidas
        if (dto.getJogoId() != null && !dto.getJogoId().equals(jogoJogador.getJogo().getId())) {
            Jogo jogo = jogoRepository.findById(dto.getJogoId())
                    .orElseThrow(() -> new EntityNotFoundException("Jogo não encontrado com o ID: " + dto.getJogoId()));
            jogoJogador.setJogo(jogo);
        }
        
        if (dto.getJogadorId() != null && !dto.getJogadorId().equals(jogoJogador.getJogador().getId())) {
            Jogador jogador = jogadorRepository.findById(dto.getJogadorId())
                    .orElseThrow(() -> new EntityNotFoundException("Jogador não encontrado com o ID: " + dto.getJogadorId()));
            jogoJogador.setJogador(jogador);
        }
        
        return jogoJogadorRepository.save(jogoJogador);
    }
    
    @Transactional
    public void delete(Long id) {
        JogoJogador jogoJogador = findById(id);
        jogoJogadorRepository.delete(jogoJogador);
    }
    
    public JogoJogadorDTO toDto(JogoJogador jogoJogador) {
        JogoJogadorDTO dto = new JogoJogadorDTO();
        dto.setJogoId(jogoJogador.getJogo().getId());
        dto.setJogadorId(jogoJogador.getJogador().getId());
        dto.setData(jogoJogador.getData());
        dto.setStatus(jogoJogador.getStatus().name());
        dto.setCartaoVermelho(jogoJogador.isCartaoVermelho());
        dto.setCartaoAmarelo(jogoJogador.isCartaoAmarelo());
        dto.setMinutosJogados(jogoJogador.getMinutosJogados());
        dto.setNotaGeral(jogoJogador.getNotaGeral());
        
        // Mapear desempenhos
        if (jogoJogador.getDesempenhoCriterios() != null) {
            List<DesempenhoCriterioJogoJogadorDTO> desempenhos = jogoJogador.getDesempenhoCriterios().stream()
                    .map(d -> {
                        DesempenhoCriterioJogoJogadorDTO ddto = new DesempenhoCriterioJogoJogadorDTO();
                        ddto.setCriterioId(d.getCriterio().getId());
                        ddto.setTentativas(d.getNumeroTentativas());
                        ddto.setAcertos(d.getNumeroAcertos());
                        ddto.setPeso(d.getPeso());
                        return ddto;
                    })
                    .collect(Collectors.toList());
            dto.setDesempenhos(desempenhos);
        }
        
        // Mapear desempenhos diretos
        if (jogoJogador.getDesempenhoCriteriosDiretos() != null) {
            List<DesempenhoCriterioDiretoJogoJogadorDTO> desempenhosDiretos = jogoJogador.getDesempenhoCriteriosDiretos().stream()
                    .map(d -> {
                        DesempenhoCriterioDiretoJogoJogadorDTO ddto = new DesempenhoCriterioDiretoJogoJogadorDTO();
                        ddto.setCriterioId(d.getCriterio().getId());
                        ddto.setOcorrencias(d.getOcorrencias());
                        ddto.setPeso(d.getPeso());
                        return ddto;
                    })
                    .collect(Collectors.toList());
            dto.setDesempenhosDiretos(desempenhosDiretos);
        }
        
        return dto;
    }
}
