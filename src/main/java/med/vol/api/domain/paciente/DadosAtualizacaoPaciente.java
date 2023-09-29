package med.vol.api.domain.paciente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.vol.api.domain.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(

        @NotNull Long id,
       @NotBlank String email,
       @NotBlank String telefone,
       @NotBlank DadosEndereco endereco
) {
}
