package manager.gm.api.domain.Models.consulta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta,Long> {

    boolean existsByMedicoIdAndData(Long idMedico, LocalDateTime data);
}
