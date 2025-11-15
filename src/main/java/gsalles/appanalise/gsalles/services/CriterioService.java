package gsalles.appanalise.gsalles.services;

import gsalles.appanalise.gsalles.dtos.CriterioDTO;
import gsalles.appanalise.gsalles.dtos.mappers.CriterioMapper;
import gsalles.appanalise.gsalles.entities.Criterio;
import gsalles.appanalise.gsalles.repository.CriterioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CriterioService {

    @Autowired
    private CriterioRepository criterioRepository;

    @Transactional(readOnly = true)
    public List<Criterio> findAll() {
        return criterioRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Criterio findById(Long id) {
        return criterioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Critério não encontrado com o ID: " + id));
    }

    @Transactional
    public Criterio create(CriterioDTO dto) {
        return criterioRepository.save(CriterioMapper.toEntity(dto));
    }

    @Transactional
    public Criterio update(Long id, CriterioDTO dto) {
        Criterio criterio = criterioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Critério não encontrado com o ID: " + id));
                
        criterio.setCriterio(dto.getCriterio());

        return criterioRepository.save(criterio);
    }

    @Transactional
    public void delete(Long id) {
        Criterio criterio = criterioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Critério não encontrado com o ID: " + id));
        criterioRepository.delete(criterio);
    }

}
