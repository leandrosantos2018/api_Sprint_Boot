package manager.gm.api.domain.Services;

import manager.gm.api.domain.Dto.Agenda.DadosAgendamento;
import manager.gm.api.domain.Models.agenda.Agendamento;
import manager.gm.api.domain.Repository.AgendamentoRepository;
import manager.gm.api.domain.Repository.ClienteRepository;
import manager.gm.api.domain.Repository.ConsultorRepository;
import manager.gm.api.domain.Repository.TipoConsultoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
         return new Agendamento( dados.idAgenamento(),
                    cliente,
                    consultor,
                    tipoConsultoria,
                    dados.dataHora(),
                    dados.observacoes(),
                    dados.statusAgendamento());

    }
        return null;
    }
}
