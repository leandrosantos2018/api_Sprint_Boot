package manager.gm.api.domain.Models.consulta;

import manager.gm.api.domain.Dto.DadosAgendamentoConsulta;
import manager.gm.api.domain.Models.consulta.validacoes.ValidadorAgendamentoConsulta;
import manager.gm.api.domain.Models.medico.Medico;
import manager.gm.api.domain.Repository.MedicoRepository;
import manager.gm.api.domain.Repository.PacienteRepository;
import manager.gm.api.infra.execption.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaDeConsultas {
    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private List<ValidadorAgendamentoConsulta> validadores;

    @Autowired
    PacienteRepository pacienteRepository;
    public void agendar(DadosAgendamentoConsulta dados){
        if(!pacienteRepository.existsById(dados.idPaciente())){
            throw  new ValidacaoException("Paciente não Cadastrado!!");
        }

        if(dados.idMedico()!=null && !medicoRepository.existsById(dados.idMedico())){
            throw  new ValidacaoException("Medico não Cadastrado!!");
        }

        validadores.forEach(v-> v.validar(dados));

       var medico = escolherMedico(dados);
        var paciente = pacienteRepository.getReferenceById(dados.idPaciente());

        var consulta = new Consulta(null,medico,paciente,dados.data());

        consultaRepository.save(consulta);
    }

   private Medico escolherMedico(DadosAgendamentoConsulta dados) {
       if (dados.idMedico() != null) {
           return medicoRepository.getReferenceById(dados.idMedico());
       }

      if(dados.especialidade() ==null){
          throw new ValidacaoException("Especialidade é obrigatoria quando medico não for escolhido!");
      }

      return  medicoRepository.escolherMedicoAleatoriaLivreNaData(dados.especialidade(), dados.data());

   }

}
