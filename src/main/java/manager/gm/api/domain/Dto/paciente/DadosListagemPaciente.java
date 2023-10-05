package manager.gm.api.domain.Dto.paciente;

import manager.gm.api.domain.Models.paciente.Paciente;

public record DadosListagemPaciente(Long id, String nome, String email, String telefone, String cpf) {
  public DadosListagemPaciente(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getTelefone() );
    }
}
