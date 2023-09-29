package med.vol.api.domain.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.vol.api.domain.endereco.Endereco;

@Table(name ="Paciente")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")

public class Paciente {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  Long id;
    private    String nome;
    private  String email;
    private String telefone;
    private  String cpf ;
    @Enumerated
    private Endereco endereco;

  public  Paciente(DadosCadastrarPaciente dados){
      this.nome = dados.nome();
      this.email = dados.email();
      this.telefone = dados.telefone();
      this.cpf = dados.cpf();
      this.endereco = new Endereco(dados.endereco());

    }

    public void atualizarDados(DadosAtualizacaoPaciente dados){

        if(dados.telefone() !=null){
            this.telefone = dados.telefone();
        }
        if(dados.email() !=null){
            this.telefone = dados.telefone();
        }
      
        if(dados.endereco() !=null){
            this.endereco.atualizaInformacoes( dados.endereco());
        }


    }


    public void excluirDados() {
    }
}
