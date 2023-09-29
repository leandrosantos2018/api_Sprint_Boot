package med.vol.api.controller;

import med.vol.api.domain.paciente.*;
import med.vol.api.domain.paciente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente")
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
        repository.deleteById(id);

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
