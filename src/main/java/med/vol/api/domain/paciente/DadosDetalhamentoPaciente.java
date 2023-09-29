package med.vol.api.domain.paciente;

public record DadosDetalhamentoPaciente(Long id,String nome, String email, String telefone, String cpf) {

    public DadosDetalhamentoPaciente(Paciente paciente){
        this(paciente.getId(),paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getTelefone());

    }
}