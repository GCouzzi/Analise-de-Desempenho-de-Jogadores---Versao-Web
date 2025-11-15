package gsalles.appanalise.gsalles.services;

import gsalles.appanalise.gsalles.dtos.CampeonatoDTO;
import gsalles.appanalise.gsalles.dtos.mappers.CampeonatoMapper;
import gsalles.appanalise.gsalles.entities.Campeonato;
import gsalles.appanalise.gsalles.repository.CampeonatoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CampeonatoService {
    
    @Autowired
    private CampeonatoRepository campeonatoRepository;

    @Transactional(readOnly = true)
    public List<Campeonato> findAll() {
        return campeonatoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Campeonato findById(Long id) {
        return campeonatoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Campeonato não encontrado com o ID: " + id));
    }
    
    @Transactional
    public Campeonato create(CampeonatoDTO dto) {
        return campeonatoRepository.save(CampeonatoMapper.toEntity(dto));
    }
    
    @Transactional
    public Campeonato update(Long id, CampeonatoDTO dto) {
        Campeonato campeonato = campeonatoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Campeonato não encontrado com o ID: " + id));

        campeonato.setNome(dto.getNome());

        return campeonatoRepository.save(campeonato);
    }
    
    @Transactional
    public void delete(Long id) {
        Campeonato campeonato = campeonatoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Campeonato não encontrado com o ID: " + id));
        campeonatoRepository.delete(campeonato);
    }

}
