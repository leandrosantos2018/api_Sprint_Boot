package manager.gm.api.domain.Dto.paciente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import manager.gm.api.domain.Dto.shared.DadosEndereco;

public record DadosAtualizacaoPaciente(

        @NotNull Long id,
       @NotBlank String email,
       @NotBlank String telefone,
       @NotBlank DadosEndereco endereco
) {
}
