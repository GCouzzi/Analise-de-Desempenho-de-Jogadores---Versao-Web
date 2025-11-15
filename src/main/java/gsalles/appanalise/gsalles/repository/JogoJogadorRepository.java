package gsalles.appanalise.gsalles.repository;

import gsalles.appanalise.gsalles.entities.JogoJogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JogoJogadorRepository extends JpaRepository<JogoJogador, Long> {
    List<JogoJogador> findByJogoId(Long jogoId);
    List<JogoJogador> findByJogadorId(Long jogadorId);
}
