package manager.gm.api.domain.Dto.medico;

import jakarta.validation.constraints.NotNull;
import manager.gm.api.domain.Dto.shared.DadosEndereco;

public record DadosAtualizacaoMedico(

        @NotNull   Long id,
        String Nome,
        String telefone,
        DadosEndereco endereco) {


}
