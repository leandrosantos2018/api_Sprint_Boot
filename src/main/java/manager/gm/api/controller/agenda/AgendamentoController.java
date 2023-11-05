package manager.gm.api.controller.agenda;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import manager.gm.api.domain.dto.Agenda.DadosAgendamento;
import manager.gm.api.domain.models.agenda.Agendamento;
import manager.gm.api.domain.models.cliente.Cliente;
import manager.gm.api.domain.repository.AgendamentoRepository;
import manager.gm.api.domain.services.Agendamento.AgendamentoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/agedamento")
@SecurityRequirement(name = "bearer-key")
public class AgendamentoController {
   @Autowired
   private AgendamentoServices agendamentoServices;

   @Autowired
   private AgendamentoRepository repository;



    @PostMapping("/Cadastrar")
    @Operation(tags = "Agendamento")
    public ResponseEntity<DadosAgendamento> CadastrarAgendamento(@RequestBody DadosAgendamento dados){
        var agendamento = agendamentoServices.CreateAgendamento(dados);
        repository.save(agendamento);
        return  ResponseEntity.ok().body(dados);
    }

    @GetMapping("/Consulta")
    @Operation(tags = "Agendamento")
    public List<Agendamento> ListaAgendamento(@PageableDefault(size = 10, sort = {"nome"}) Pageable pagina){
        return repository.findAll();
    }


    @GetMapping("Consulta/{id}")
    @Operation(tags = "Agendamento")
    public List<Agendamento> ListaAgendamentoById(@PathVariable Long id){
        try{
            var agendamento =  agendamentoServices.ListByID( id);

            return  agendamento;
        }catch (Exception ex ){

            throw  new RuntimeException(ex.getMessage());

        }
    }

    @DeleteMapping("/Excluir/{id}")
    @Operation(tags = "Agendamento")
    public ResponseEntity ExcluirAgendamento(@PathVariable Long id){
        try {
            var agendamento = repository.getReferenceById(id);
            repository.delete(agendamento);
            return  ResponseEntity.ok().body(agendamento);
        }catch (Exception ex){
            return ResponseEntity.ok(ex.getStackTrace());
        }

    }
}
