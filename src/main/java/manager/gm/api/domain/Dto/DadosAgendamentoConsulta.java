package manager.gm.api.domain.Dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import manager.gm.api.domain.Models.medico.Especialidade;

import java.time.LocalDateTime;

public record DadosAgendamentoConsulta(
  @JsonAlias("Id_Medico") Long idMedico,
        @NotNull
        @JsonAlias("Id_Paciente")
        Long idPaciente,
        @NotNull
        @Future
        @JsonAlias("Data_Agendamento")
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime data,

        Especialidade especialidade
) {
}
