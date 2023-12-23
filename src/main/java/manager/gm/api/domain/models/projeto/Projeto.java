package manager.gm.api.domain.models.projeto;

import jakarta.persistence.*;



@Entity
@Table(name = "projetos")
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_projeto")
    private Long idProjeto;
    private String nomeProjeto;
    @Column(name = "descricao_projeto", columnDefinition = "TEXT")
    private String descricaoProjeto;

    public Projeto(String nomeProjeto, String descricaoProjeto) {
        this.nomeProjeto = nomeProjeto;
        this.descricaoProjeto = descricaoProjeto;
    }

    // @ManyToOne
   // @JoinColumn(name = "id_gerente_responsavel")
    // private Gerente gerenteResponsavel;

}
