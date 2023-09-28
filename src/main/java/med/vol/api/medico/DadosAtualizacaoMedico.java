package med.vol.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.vol.api.endereco.DadosEndereco;
import med.vol.api.endereco.Endereco;

public record DadosAtualizacaoMedico(

        @NotNull   Long id,
        String Nome,
        String telefone,
        DadosEndereco endereco) {


}
