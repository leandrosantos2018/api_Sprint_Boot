package med.vol.api.controller;

import jakarta.validation.Valid;
import med.vol.api.endereco.Endereco;
import med.vol.api.medico.DadosCadastrarMedico;
import med.vol.api.medico.DadosListagemMedico;
import med.vol.api.medico.Medico;
import med.vol.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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


        return repository.findAll(pagina).map(DadosListagemMedico:: new);

    }
}
