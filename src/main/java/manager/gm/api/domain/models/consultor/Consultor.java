package manager.gm.api.domain.models.consultor;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;



@Table(name ="consultores")
@Entity(name = "consultores")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Consultor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id_consultor")
    private Long idConsultor;

    @NotBlank
    private String nome;
    @NotNull
    private String sobrenome;
    @NotNull
    private String especializacao;
    @NotNull
//    @Email
    private String email;
    @NotNull
    private String telefone;

    @Column(name = "outras_informacoes", columnDefinition = "TEXT")
    private String outrasInformacoes;

  public   Consultor(String nome,String sobrenome, String especializacao,String email,String telefone){
      this.nome = nome;
      this.sobrenome = sobrenome;
      this.especializacao = especializacao;
      this.email = email;
      this.telefone = telefone;
    }



}

