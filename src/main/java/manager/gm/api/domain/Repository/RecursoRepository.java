package manager.gm.api.domain.Repository;

import manager.gm.api.domain.Models.Recurso.Recurso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecursoRepository extends JpaRepository<Recurso,Long> {
}
