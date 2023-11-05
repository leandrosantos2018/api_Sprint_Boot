package manager.gm.api.domain.repository;

import manager.gm.api.domain.models.agenda.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento,Long> {

}
