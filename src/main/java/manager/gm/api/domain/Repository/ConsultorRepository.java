package manager.gm.api.domain.Repository;

import manager.gm.api.domain.Models.consultor.Consultor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultorRepository extends JpaRepository<Consultor,Long> {
}
