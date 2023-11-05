package manager.gm.api.domain.models.agenda;


import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import manager.gm.api.domain.models.Enum.StatusAgendamento;
import manager.gm.api.domain.models.cliente.Cliente;
import manager.gm.api.domain.models.consultor.Consultor;
import manager.gm.api.domain.models.consultoria.TipoConsultoria;

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
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_consultor")
    private Consultor consultor;

    @ManyToOne

    @JoinColumn(name = "id_tipo_consultoria")
    private TipoConsultoria tipoConsultoria;


    private boolean Faturavel;

    // Adicione o campo id_projeto aqui

    @Temporal(TemporalType.TIMESTAMP)

    @Column(name = "data_hora")
    @Future
    private Date dataHora;

    private String observacoes;

    @Column(name = "status_agendamento")

    private StatusAgendamento statusAgendamento;

    public Agendamento(){}

}
