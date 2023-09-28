package med.vol.api.controller;

import jakarta.validation.Valid;
import med.vol.api.endereco.Endereco;
import med.vol.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastrarMedico dados){

        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> Listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pagina){
        return repository.findAllByAtivoTrue(pagina).map(DadosListagemMedico:: new);
    }


    @PutMapping
    @Transactional
    public String Atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){

        Long id = dados.id();

        if (id == null) {
            throw new IllegalArgumentException("O ID não pode ser nulo");
        }
        var medico = repository.getReferenceById(id);
        medico.atualizarInformacoes(dados);
        return "Atualização do Medico do id: " + id;
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
       var medico =  repository.getReferenceById(id);
       medico.excluir();

    }

}
