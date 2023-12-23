package manager.gm.api.domain.repository;

import manager.gm.api.domain.models.consultoria.TipoConsultoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TipoConsultoriaRepository extends JpaRepository<TipoConsultoria,Long> {

}
