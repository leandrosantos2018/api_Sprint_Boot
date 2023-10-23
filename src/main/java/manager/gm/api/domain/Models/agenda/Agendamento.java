package manager.gm.api.domain.Models.agenda;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import manager.gm.api.domain.Models.StatusAgendamento;
import manager.gm.api.domain.Models.cliente.Cliente;
import manager.gm.api.domain.Models.consultor.Consultor;
import manager.gm.api.domain.Models.consultoria.TipoConsultoria;

import java.util.Date;

@Entity(name = "agendamentos")
@Table(name = "agendamentos")
@Getter
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long idAgendamento;

    @ManyToOne
    @NotBlank
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @NotBlank
    @JoinColumn(name = "id_consultor")
    private Consultor consultor;

    @ManyToOne
    @NotBlank
    @JoinColumn(name = "id_tipo_consultoria")
    private TipoConsultoria tipoConsultoria;

    // Adicione o campo id_projeto aqui

    @Temporal(TemporalType.TIMESTAMP)
    @NotBlank
    @Column(name = "data_hora")
  //  @Future
    private Date dataHora;

    private String observacoes;

    @Column(name = "status_agendamento")
    @NotBlank
    private StatusAgendamento statusAgendamento;

}
