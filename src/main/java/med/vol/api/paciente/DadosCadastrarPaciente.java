package med.vol.api.paciente;

import jakarta.validation.constraints.NotBlank;
import med.vol.api.endereco.DadosEndereco;

public record DadosCadastrarPaciente(
        @NotBlank String nome,
        @NotBlank String email,
        @NotBlank String telefone,
        @NotBlank String cpf ,

        @NotBlank    DadosEndereco endereco) {

}
