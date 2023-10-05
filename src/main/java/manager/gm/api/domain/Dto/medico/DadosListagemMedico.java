package manager.gm.api.domain.Dto.medico;

import manager.gm.api.domain.Models.medico.Especialidade;
import manager.gm.api.domain.Models.medico.Medico;

public record DadosListagemMedico(Long id , String nome, String email, String crm, Especialidade especialidade, String telefone ) {
    public DadosListagemMedico(Medico medico){
        this(medico.getId(),medico.getNome(),medico.getEmail(), medico.getCrm(),medico.getEspecialidade(),medico.getTelefone());
    }
}
