package med.vol.api.paciente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.vol.api.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(

        @NotNull Long id,
       @NotBlank String email,
       @NotBlank String telefone,
       @NotBlank DadosEndereco endereco
) {
}
