package gsalles.appanalise.gsalles.repository;

import gsalles.appanalise.gsalles.entities.Campeonato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampeonatoRepository extends JpaRepository<Campeonato, Long> {
}
