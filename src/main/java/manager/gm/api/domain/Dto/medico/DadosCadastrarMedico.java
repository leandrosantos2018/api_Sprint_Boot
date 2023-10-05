package manager.gm.api.domain.Dto.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import manager.gm.api.domain.Dto.shared.DadosEndereco;
import manager.gm.api.domain.Models.medico.Especialidade;

public record DadosCadastrarMedico(

        @NotBlank(message = "Nome é obrigatório!")
        String nome,
        @NotBlank(message = "email é obrigatório!")
        @Email
        String email,

        @NotBlank(message = "telefone é obrigatório!")
        String telefone,

        @NotBlank(message = "crm é obrigatório!")
        @Pattern(regexp = "\\d{4,6}")
        String crm ,
        @NotNull(message = "especialidade é obrigatório!")
        Especialidade especialidade,
        @NotNull(message = "endereco é obrigatório!")
        @Valid
        DadosEndereco endereco) {

}
