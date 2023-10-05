package manager.gm.api.domain.Models.consulta.validacoes;

import manager.gm.api.domain.Dto.DadosAgendamentoConsulta;
import manager.gm.api.domain.Repository.MedicoRepository;
import med.vol.api.domain.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoConsulta {

    @Autowired
    private MedicoRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        if(dados.idMedico() == null){
            return;
        }


        var medicoEstaAtivo = repository.findAtivoById(dados.idMedico());

        if(!medicoEstaAtivo){
            throw  new ValidacaoException("Consulta não pode ser agendada com Médico inativo");
        }
    }
}
