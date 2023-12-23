package manager.gm.api.domain.repository;

import manager.gm.api.domain.models.consultor.Consultor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultorRepository extends JpaRepository<Consultor,Long> {
}
