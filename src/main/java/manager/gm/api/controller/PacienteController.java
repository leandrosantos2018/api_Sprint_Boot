package manager.gm.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import manager.gm.api.domain.Dto.paciente.DadosAtualizacaoPaciente;
import manager.gm.api.domain.Dto.paciente.DadosCadastrarPaciente;
import manager.gm.api.domain.Dto.paciente.DadosDetalhamentoPaciente;
import manager.gm.api.domain.Dto.paciente.DadosListagemPaciente;
import manager.gm.api.domain.Repository.PacienteRepository;
import manager.gm.api.domain.Models.paciente.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente")
@SecurityRequirement(name = "bearer-key")

public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional

    public void CadastrarPaciente(@RequestBody DadosCadastrarPaciente dados){

       repository.save( new Paciente(dados));

    }

    @GetMapping

    public Page<DadosListagemPaciente> ListarPaciente(@PageableDefault(size = 10, sort = {"nome"}) Pageable pagina){
        return repository.findAll(pagina).map(DadosListagemPaciente:: new);

    }

    @PutMapping
    @Transactional

     public void AtualizarPaciente (@RequestBody DadosAtualizacaoPaciente dados){
        Long id = dados.id();
        if (id == null) {
            throw new IllegalArgumentException("O ID não pode ser nulo");
        }
        var paciente = repository.getReferenceById(id);
        paciente.atualizarDados(dados);

    }

    @DeleteMapping("/{id}")
    @Transactional

    public void ExcluirPaciente(@PathVariable Long id){

        var paciente = repository.getReferenceById(id);
        repository.deleteById(paciente.getId());

    }

    @GetMapping("/{id}")

    public ResponseEntity detalharPaciente(@PathVariable Long id){

        if (id == null) {
            throw new IllegalArgumentException("O ID não pode ser nulo");
        }

        var paciente = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));

    }
}
