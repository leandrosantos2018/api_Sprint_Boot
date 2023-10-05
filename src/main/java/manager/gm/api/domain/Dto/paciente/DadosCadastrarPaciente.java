package manager.gm.api.domain.Dto.paciente;

import jakarta.validation.constraints.NotBlank;
import manager.gm.api.domain.Dto.shared.DadosEndereco;

public record DadosCadastrarPaciente(
        @NotBlank String nome,
        @NotBlank String email,
        @NotBlank String telefone,
        @NotBlank String cpf ,

        @NotBlank DadosEndereco endereco) {

}
