package manager.gm.api.controller.Projeto;

import manager.gm.api.domain.dto.Projeto.DadosCadstrarProjeto;
import manager.gm.api.domain.models.projeto.Projeto;
import manager.gm.api.domain.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/Projeto")
public class ProjetoController {

    @Autowired
    ProjetoRepository repository;

    @PostMapping("/createProject")
    public ResponseEntity create(@RequestBody DadosCadstrarProjeto dadosprojeto){
        var projeto = new Projeto(dadosprojeto.nomeProjeto(),dadosprojeto.DescricaoProjeto());

        repository.save(projeto);

        return ResponseEntity.status(201).body(projeto);
    }

    @GetMapping("/GetProject")
    public ResponseEntity get(){
      List<Projeto> projetos =   repository.findAll();

        return ResponseEntity.status(200).body(projetos);
    }

}
