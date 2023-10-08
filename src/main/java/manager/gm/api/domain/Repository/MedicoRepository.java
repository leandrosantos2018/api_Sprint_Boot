package manager.gm.api.domain.Repository;

import manager.gm.api.domain.Models.medico.Especialidade;
import manager.gm.api.domain.Models.medico.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface MedicoRepository extends JpaRepository<Medico,Long> {

    Page<Medico> findAllByAtivoTrue(Pageable pagina);

    @Query("""
            select m from Medicos m
                   where
                   m.ativo = true
                   and
                   m.especialidade = :especialidade
                   and
                   m.id not in(
                       select c.medico.id from Consulta c
                       where
                       c.data = :data
                   )
                   order by rand()
                   limit 1
            """)
    Medico escolherMedicoAleatoriaLivreNaData(Especialidade especialidade, LocalDateTime data);

    @Query("""
            select m.ativo
             from Medicos m 
             where m.id=:idMedico  
            """)
    boolean findAtivoById(Long idMedico);

//    boolean existsByMedicoIdAndData(Long IdMedico, LocalDateTime data);
}
