package manager.gm.api.controller.consultoria;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import manager.gm.api.domain.dto.consultoria.DadosTipoConsultoria;

import manager.gm.api.domain.models.consultoria.TipoConsultoria;
import manager.gm.api.domain.repository.TipoConsultoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/TipoConsultoria")
@SecurityRequirement(name = "bearer-key")
public class ConsultoriaController {

    @Autowired
    private TipoConsultoriaRepository repository;
    @PostMapping("/Cadastrar")
    @Operation(tags = "Tipo Consultoria")
    public ResponseEntity CadastrarTipoConsultoria(@RequestBody DadosTipoConsultoria dados){

     var Consultoria = new TipoConsultoria(dados.idTipoConsultoria(),
             dados.nomeTipoConsultoria(),
             dados.descricao(),
             dados.taxaPorHora());

     repository.save(Consultoria);

     return ResponseEntity.status(201).body("TipoConsultoria Cadastrado com sucesso" + dados);

    }

    @GetMapping("/Consulta")
    @Operation(tags = "Tipo Consultoria")
    public List<TipoConsultoria> ListarTipoConsultoria(@PageableDefault(size = 10, sort = {"id"}) Pageable pagina){
        return repository.findAll();
    }


    @DeleteMapping("/Excluir/{id}")
    @Operation(tags = "Tipo Consultoria")
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
