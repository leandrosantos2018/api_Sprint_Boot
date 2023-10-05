package manager.gm.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import manager.gm.api.domain.Dto.DadosAgendamentoConsulta;
import manager.gm.api.domain.Dto.DadosDetalhamentoConsulta;
import manager.gm.api.domain.Models.consulta.AgendaDeConsultas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultas")
@Api(value = "Consulta Controller")
public class ConsultaController {

    @Autowired
    private AgendaDeConsultas agenda;

    @PostMapping
    @Transactional
    @ApiOperation(value = "Agendamento de Consulta")
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsulta dados){

        agenda.agendar(dados);
        return  ResponseEntity.ok( new DadosDetalhamentoConsulta(null,null, null,null));

    }


}
