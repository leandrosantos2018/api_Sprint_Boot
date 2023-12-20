package manager.gm.api.domain.repository;

import manager.gm.api.domain.models.projeto.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto,Long> {
}
