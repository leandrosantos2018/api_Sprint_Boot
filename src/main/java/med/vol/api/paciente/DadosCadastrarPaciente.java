package med.vol.api.paciente;

import med.vol.api.endereco.DadosEndereco;

public record DadosCadastrarPaciente(String nome, String email, String telefone, String cpf , DadosEndereco endereco) {

}
