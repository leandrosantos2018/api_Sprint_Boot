package med.vol.api.paciente;

import med.vol.api.endereco.Endereco;

public record DadosListagemPaciente(String nome, String email, String telefone, String cpf) {
  public DadosListagemPaciente(Paciente paciente){
        this(paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getTelefone() );
    }
}
