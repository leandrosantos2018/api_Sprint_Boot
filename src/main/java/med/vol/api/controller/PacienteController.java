package med.vol.api.controller;

import med.vol.api.paciente.DadosCadastrarPaciente;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @PostMapping
    public void CadastrarPaciente(@RequestBody DadosCadastrarPaciente paciente){

        System.out.println(paciente);

    }
}
