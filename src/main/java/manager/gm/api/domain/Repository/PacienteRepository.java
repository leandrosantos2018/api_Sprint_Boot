package manager.gm.api.domain.Repository;

import manager.gm.api.domain.Models.paciente.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente,Long> {
}
