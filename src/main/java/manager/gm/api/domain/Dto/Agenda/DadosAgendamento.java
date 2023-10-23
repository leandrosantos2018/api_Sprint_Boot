package manager.gm.api.domain.Dto.Agenda;

import manager.gm.api.domain.Models.StatusAgendamento;
import org.springframework.stereotype.Component;

import java.util.Date;


public record DadosAgendamento(
        Long idAgenamento,
        Long idcliente,
        Long idconsultor,
        Long tipoConsultoria,
        Date dataHora,
        String observacoes,
        StatusAgendamento statusAgendamento) {


}
