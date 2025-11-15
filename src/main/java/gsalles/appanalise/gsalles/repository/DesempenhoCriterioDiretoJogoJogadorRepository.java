package gsalles.appanalise.gsalles.repository;

import gsalles.appanalise.gsalles.entities.DesempenhoCriterioDiretoJogoJogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DesempenhoCriterioDiretoJogoJogadorRepository extends JpaRepository<DesempenhoCriterioDiretoJogoJogador, Long> {
    List<DesempenhoCriterioDiretoJogoJogador> findByJogoJogadorId(Long id);
}
