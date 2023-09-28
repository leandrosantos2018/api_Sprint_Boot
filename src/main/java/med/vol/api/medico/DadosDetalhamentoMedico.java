package med.vol.api.medico;

import med.vol.api.endereco.Endereco;

public record DadosDetalhamentoMedico(Long id , String nome, String email, String crm, Especialidade especialidade, String telefone, Endereco endereco  ) {



    public DadosDetalhamentoMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getTelefone(), medico.getEspecialidade(), medico.getCrm(),medico.getEndereco());
    }
}
