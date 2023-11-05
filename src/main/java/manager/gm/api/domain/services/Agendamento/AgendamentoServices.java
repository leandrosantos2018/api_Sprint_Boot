package manager.gm.api.domain.services.Agendamento;

import manager.gm.api.domain.dto.Agenda.DadosAgendamento;
import manager.gm.api.domain.models.agenda.Agendamento;
import manager.gm.api.domain.repository.AgendamentoRepository;
import manager.gm.api.domain.repository.ClienteRepository;
import manager.gm.api.domain.repository.ConsultorRepository;
import manager.gm.api.domain.repository.TipoConsultoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoServices {
    @Autowired
    private AgendamentoRepository repository;

    @Autowired
    private ConsultorRepository consultorRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private TipoConsultoriaRepository tipoConsultoriaRepository;
    public Agendamento CreateAgendamento(DadosAgendamento dados){

        if (dados != null) {
            var consultor = consultorRepository.getReferenceById(dados.idconsultor());
            var cliente = clienteRepository.getReferenceById(dados.idcliente());

            var tipoConsultoria = tipoConsultoriaRepository.getReferenceById(dados.tipoConsultoria());
            System.out.println(tipoConsultoria.getIdTipoConsultoria());
         return new Agendamento( dados.idAgenamento(),
                    cliente,
                    consultor,
                    tipoConsultoria,
                    dados.Faturavel(),
                    dados.dataHora(),
                    dados.observacoes(),
                    dados.statusAgendamento());

    }
        return null;
    }

    public List<Agendamento> ListByID(Long id) {
        var agendamento = repository.getReferenceById(id);
        return (List<Agendamento>) agendamento;
    }
}
