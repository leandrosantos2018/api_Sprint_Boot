package manager.gm.api.domain.Models.consulta.validacoes;

import manager.gm.api.domain.Dto.DadosAgendamentoConsulta;
import manager.gm.api.infra.execption.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class validadorHorarioFuncionamentoClinica implements ValidadorAgendamentoConsulta{
    public void validar (DadosAgendamentoConsulta dados){
        var dataConsulta = dados.data();

        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAberturaClinica =  dataConsulta.getHour()<7;
        var depoisDoEncerramentoDaClinica = dataConsulta.getHour() <18;

        if(domingo|| antesDaAberturaClinica|| depoisDoEncerramentoDaClinica){
            throw new ValidacaoException("Consulta fora do horario de funcionamento da clinica");
        }


    }
}
