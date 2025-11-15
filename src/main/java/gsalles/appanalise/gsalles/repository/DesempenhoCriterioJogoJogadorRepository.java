package gsalles.appanalise.gsalles.repository;

import gsalles.appanalise.gsalles.entities.DesempenhoCriterioJogoJogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesempenhoCriterioJogoJogadorRepository extends JpaRepository<DesempenhoCriterioJogoJogador, Long> {
}
