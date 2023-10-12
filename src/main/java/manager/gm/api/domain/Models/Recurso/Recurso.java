package manager.gm.api.domain.Models.Recurso;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name ="Recurso")
@Entity(name = "Recurso")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Recurso {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;


    @NotNull(message = "nome não pode ser nulo")
    private String nome;

    @NotBlank
    private String email;

    @NotNull
    private PapelRecurso papelRecurso;


    public Recurso(String nome, String email,  PapelRecurso papelRecurso) {
      this.nome = nome;
      this.email = email;
      this.papelRecurso = papelRecurso;

    }



}
