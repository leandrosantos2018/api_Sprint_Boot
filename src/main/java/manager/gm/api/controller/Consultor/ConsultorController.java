package manager.gm.api.controller.Consultor;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import manager.gm.api.domain.Dto.consultor.DadosCadastrarConsultor;
import manager.gm.api.domain.Models.consultor.Consultor;
import manager.gm.api.domain.Repository.ConsultorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Consultor")
@SecurityRequirement(name = "bearer-key")
public class ConsultorController {

    private ConsultorRepository repository;
    @PostMapping("/Cadastrar")
    @Transactional
    public ResponseEntity CadastrarConsultor(@RequestBody  DadosCadastrarConsultor dados){
        if(dados !=null){
            var consultor = new Consultor(dados.nome(), dados.sobrenome(), dados.email(), dados.especializacao(), dados.telefone());
            repository.save(consultor);
            return ResponseEntity.status(201).body(dados);
        }

        return  ResponseEntity.badRequest().build();

    }
}
