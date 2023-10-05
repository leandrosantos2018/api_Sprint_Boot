package manager.gm.api.domain.Models.consulta.validacoes;

import manager.gm.api.domain.Dto.DadosAgendamentoConsulta;
import manager.gm.api.infra.execption.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadoHorarioAntecedencia implements ValidadorAgendamentoConsulta{

    public void validar (DadosAgendamentoConsulta dados){
        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferencaEmminuto = Duration.between(agora,dataConsulta).toMinutes();

        if(diferencaEmminuto<30){
            throw  new ValidacaoException("Consulta deve ser agenda com minimo 30 minuto");
        }

    }
}
