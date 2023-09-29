package med.vol.api.domain.paciente;

import jakarta.validation.constraints.NotBlank;
import med.vol.api.domain.endereco.DadosEndereco;

public record DadosCadastrarPaciente(
        @NotBlank String nome,
        @NotBlank String email,
        @NotBlank String telefone,
        @NotBlank String cpf ,

        @NotBlank    DadosEndereco endereco) {

}
