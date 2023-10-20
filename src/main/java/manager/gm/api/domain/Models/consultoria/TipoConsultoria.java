package manager.gm.api.domain.Models.consultoria;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity(name = "tipos_consultoria")
@Table(name = "tipos_consultoria")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class TipoConsultoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_consultoria")
    private Long idTipoConsultoria;

    @Column(name = "nome_tipo_consultoria")
    private String nomeTipoConsultoria;

    private String descricao;

    @Column(name = "taxa_por_hora")
    private BigDecimal taxaPorHora;
  public  TipoConsultoria(Long idTipoConsultoria,
                    String nomeTipoConsultoria,
                    String descricao,
                    BigDecimal taxaPorHora){
        this.idTipoConsultoria = idTipoConsultoria;
        this.nomeTipoConsultoria = nomeTipoConsultoria;
        this.descricao = descricao;
        this.taxaPorHora = taxaPorHora;
    }
}
