package med.vol.api.controller;

import med.vol.api.medico.DadosListagemMedico;
import med.vol.api.medico.Medico;
import med.vol.api.medico.MedicoRepository;
import med.vol.api.paciente.DadosCadastrarPaciente;
import med.vol.api.paciente.DadosListagemPaciente;
import med.vol.api.paciente.Paciente;
import med.vol.api.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.function.Function;

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


        return repository.findAll(pagina).map((Function<? super Paciente, ? extends DadosListagemPaciente>) DadosListagemPaciente:: new);

    }
}
