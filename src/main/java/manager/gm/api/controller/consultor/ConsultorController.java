package manager.gm.api.controller.consultor;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import manager.gm.api.domain.dto.consultor.DadosCadastrarConsultor;
import manager.gm.api.domain.models.consultor.Consultor;
import manager.gm.api.domain.models.consultoria.TipoConsultoria;
import manager.gm.api.domain.repository.ConsultorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Consultor")
@SecurityRequirement(name = "bearer-key")
public class ConsultorController {

    @Autowired
    private ConsultorRepository repository;
    @PostMapping("/Cadastrar")
    @Transactional
    @Operation(tags = "Consultor")
    public ResponseEntity CadastrarConsultor(@RequestBody  DadosCadastrarConsultor dados){
        if(dados !=null){
            var consultor = new Consultor(dados.nome(), dados.sobrenome(), dados.email(), dados.especializacao(), dados.telefone());
            repository.save(consultor);
            return ResponseEntity.status(201).body(dados);
        }

        return  ResponseEntity.badRequest().build();

    }

    @GetMapping("/Consulta")
    @Operation(tags = "Consultor")
    public List<Consultor> ListarConsultor( Pageable pagina){
        return repository.findAll();
    }
}
