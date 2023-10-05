package manager.gm.api.domain.Models.consulta.validacoes;

import manager.gm.api.domain.Dto.DadosAgendamentoConsulta;
import manager.gm.api.domain.Models.consulta.ConsultaRepository;
import manager.gm.api.domain.Repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMEdicoComoutraConsultaNaMesmaHorario {

    @Autowired
    private ConsultaRepository repository;



    public void validar(DadosAgendamentoConsulta dados){
        var medicoPossuiOutraConsultaNoMesmoHorario = repository.existsByMedicoIdAndData(dados.idMedico(),dados.data());
    }
}
