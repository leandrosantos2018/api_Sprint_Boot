package manager.gm.api.domain.Models.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import manager.gm.api.domain.Dto.medico.DadosAtualizacaoMedico;
import manager.gm.api.domain.Dto.medico.DadosCadastrarMedico;
import manager.gm.api.domain.Models.endereco.Endereco;

@Table(name ="Medicos")
@Entity(name = "Medicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Medico {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;

    private String crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Enumerated
    private Endereco endereco;

    private Boolean ativo;

    public Medico(DadosCadastrarMedico dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.endereco = new Endereco(dados.endereco());
        this.especialidade = dados.especialidade();

    }

    public Medico atualizarInformacoes(DadosAtualizacaoMedico dados) {
        if(dados.Nome()!= null){
            this.nome = dados.Nome();
        }
        if (dados.telefone() != null){
            this.telefone = dados.telefone();
        }

        if(dados.endereco() !=null){
            this.endereco.atualizaInformacoes( dados.endereco());
        }

        return Medico.this;
    }


    public void ExclusaoLogica() {
        this.ativo = false;
    }
}
