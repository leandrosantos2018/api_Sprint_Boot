package manager.gm.api.domain.Models.consulta.validacoes;

import manager.gm.api.domain.Dto.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;


public interface ValidadorAgendamentoConsulta {
     void validar(DadosAgendamentoConsulta dados);
}
