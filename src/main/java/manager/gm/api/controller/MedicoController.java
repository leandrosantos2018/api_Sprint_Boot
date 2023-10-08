package manager.gm.api.controller;


import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import manager.gm.api.domain.Dto.medico.DadosAtualizacaoMedico;
import manager.gm.api.domain.Dto.medico.DadosCadastrarMedico;
import manager.gm.api.domain.Dto.medico.DadosDetalhamentoMedico;
import manager.gm.api.domain.Dto.medico.DadosListagemMedico;
import manager.gm.api.domain.Repository.MedicoRepository;

import manager.gm.api.domain.Models.medico.Medico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medicos")
@SecurityRequirement(name = "bearer-key")

public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional

    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastrarMedico dados, UriComponentsBuilder uibuilder){

        var medico = new Medico(dados);
        repository.save(medico);
        var uri = uibuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return  ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medico));
    }

    @GetMapping()
    public ResponseEntity<Page<DadosListagemMedico>> Listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pagina){
        var page = repository.findAllByAtivoTrue(pagina).map(DadosListagemMedico:: new);
        return  ResponseEntity.ok(page);
    }


    @PutMapping
    @Transactional

    public ResponseEntity Atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){

        Long id = dados.id();

        if (id == null) {
            throw new IllegalArgumentException("O ID não pode ser nulo");
        }
        var medico = repository.getReferenceById(id);
        medico.atualizarInformacoes(dados);
        return ResponseEntity.ok( new DadosDetalhamentoMedico(medico));
    }
    @DeleteMapping("/{id}")
    @Transactional

    public ResponseEntity excluir(@PathVariable Long id){
       var medico =  repository.getReferenceById(id);
       medico.ExclusaoLogica();

       return ResponseEntity.noContent().build();

    }

    @GetMapping("/{id}")

    public ResponseEntity detalhar(@PathVariable Long id){

        var medico =  repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));

    }


}
