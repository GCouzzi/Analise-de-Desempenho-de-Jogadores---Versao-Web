package gsalles.appanalise.gsalles.repository;

import gsalles.appanalise.gsalles.entities.Criterio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CriterioRepository extends JpaRepository<Criterio, Long> {
}
