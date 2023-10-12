package manager.gm.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import manager.gm.api.domain.Dto.DadosCadastrarRecurso;
import manager.gm.api.domain.Models.Recurso.Recurso;
import manager.gm.api.domain.Repository.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recurso")
@SecurityRequirement(name = "bearer-key")
public class RecursoController {

    @Autowired
    private RecursoRepository recursoRepository;

    @PostMapping("Cadastrar")
    public ResponseEntity CadastrarRecurso(@RequestBody @Valid DadosCadastrarRecurso dados ){

        if(dados != null){
           var recurso = new Recurso(dados.nome(),dados.email(),dados.papelRecurso());
           recursoRepository.save(recurso);
        }

        return  ResponseEntity.ok().build();

    }
}
