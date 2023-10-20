package manager.gm.api.controller.consultoria;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import manager.gm.api.domain.Dto.consultoria.DadosTipoConsultoria;

import manager.gm.api.domain.Models.consultoria.TipoConsultoria;
import manager.gm.api.domain.Repository.TipoConsultoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/TipoConsultoria")
@SecurityRequirement(name = "bearer-key")
public class ConsultoriaController {

    @Autowired
    private TipoConsultoriaRepository repository;
    @PostMapping("/Cadstrar")
    public ResponseEntity CadastrarTipoConsultoria(@RequestBody DadosTipoConsultoria dados){

     var Consultoria = new TipoConsultoria(dados.idTipoConsultoria(),
             dados.nomeTipoConsultoria(),
             dados.descricao(),
             dados.taxaPorHora());

     repository.save(Consultoria);

     return ResponseEntity.status(201).body("TipoConsultoria Cadastrado com sucesso" + dados);

    }

    @DeleteMapping("Excluir/{id}")
    public ResponseEntity ExcluirTipoConsultoria(@PathVariable Long id){
        try {
            var tipoconsultoria = repository.getReferenceById(id);
            repository.delete(tipoconsultoria);
            return  ResponseEntity.ok().body("Tipo Consultoria Excluido com sucesso!"+ " "+ tipoconsultoria);
        }catch (Exception ex){
            return ResponseEntity.ok(ex.getStackTrace());
        }


    }




}
