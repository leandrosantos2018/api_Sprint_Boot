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

   // @ManyToOne
   // @JoinColumn(name = "id_gerente_responsavel")
    // private Gerente gerenteResponsavel;

}
