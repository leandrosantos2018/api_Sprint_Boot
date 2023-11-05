package manager.gm.api.domain.dto.Agenda;

import manager.gm.api.domain.models.Enum.StatusAgendamento;

import java.util.Date;


public record DadosAgendamento(
        Long idAgenamento,
        Long idcliente,
        Long idconsultor,
        Long tipoConsultoria,
        Boolean Faturavel,
        Date dataHora,
        String observacoes,
        StatusAgendamento statusAgendamento) {


}
