package manager.gm.api.domain.Models.cliente;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name ="Clientes")
@Entity(name = "Clientes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")

public class Cliente {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idcliente;

    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    private String endereco;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String telefone;

    @Column(name = "outras_informacoes", columnDefinition = "TEXT",length = 255)
    private String outrasInformacoes;

   public  Cliente(String nome,String Sobrenome,String endereco,String email,
                   String telefone){
       this.nome = nome;
       this.sobrenome =Sobrenome;
       this.endereco = endereco;
       this.email = email;
       this.telefone = telefone;



    }

}