package manager.gm.api.domain.Dto.medico;

import manager.gm.api.domain.Models.endereco.Endereco;
import manager.gm.api.domain.Models.medico.Especialidade;
import manager.gm.api.domain.Models.medico.Medico;

public record DadosDetalhamentoMedico(Long id , String nome, String email, String crm, Especialidade especialidade, String telefone, Endereco endereco  ) {



    public DadosDetalhamentoMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getTelefone(), medico.getEspecialidade(), medico.getCrm(),medico.getEndereco());
    }
}
