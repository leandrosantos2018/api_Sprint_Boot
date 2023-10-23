package manager.gm.api.controller.Agenda;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import manager.gm.api.domain.Dto.Agenda.DadosAgendamento;
import manager.gm.api.domain.Models.StatusAgendamento;
import manager.gm.api.domain.Models.agenda.Agendamento;
import manager.gm.api.domain.Repository.AgendamentoRepository;
import manager.gm.api.domain.Repository.ClienteRepository;
import manager.gm.api.domain.Repository.ConsultorRepository;
import manager.gm.api.domain.Repository.TipoConsultoriaRepository;
import manager.gm.api.domain.Services.AgendamentoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController("/Agedamento")
@SecurityRequirement(name = "bearer-key")
public class AgendamentoController {
   @Autowired
   private AgendamentoServices agendamentoServices;

   @Autowired
   private AgendamentoRepository repository;



    @PostMapping("/Cadastrar")
    public ResponseEntity<DadosAgendamento> CadastrarAgendamento(@RequestBody DadosAgendamento dados){

        var agendamento = agendamentoServices.CreateAgendamento(dados);
            repository.save(agendamento);
            return  ResponseEntity.ok().body(dados);

    }
}
