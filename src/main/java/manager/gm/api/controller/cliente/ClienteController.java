package manager.gm.api.controller.cliente;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import manager.gm.api.domain.dto.cliente.DadosCadastrarCliente;
import manager.gm.api.domain.models.cliente.Cliente;
import manager.gm.api.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/Cliente")
@SecurityRequirement(name = "bearer-key")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;


    @PostMapping("/Cadastrar")
    @Operation(tags = "Cliente")
    public ResponseEntity CadastrarCliente(@RequestBody @Valid DadosCadastrarCliente dados){

        if (dados != null){
            var cliente = new Cliente(dados.nome(),dados.sobrenome(),dados.endereco(),dados.email(),dados.telefone());

            repository.save(cliente);
            return  ResponseEntity.status(201).body("Cliente Cadastrado com Sucesso");
        }

        return ResponseEntity.ofNullable(dados);
    }

    @GetMapping("/Consulta")
    @Operation(tags = "Cliente")
    public List<Cliente> ListarCliente(@PageableDefault(size = 10, sort = {"nome"}) Pageable pagina){
        return repository.findAll();
    }

    @GetMapping("/Consulta/{id}")
    @Operation(tags = "Cliente")

    public List<Cliente> ListarClienteID(Long id){
        var cliente = repository.findAllById(Collections.singleton(id));

        return cliente;
    }

    @PutMapping("/Atualizar")
    @Operation(tags = "Cliente")
    @Transactional
    public ResponseEntity  ListarClienteID(@RequestBody DadosCadastrarCliente dados){

        int rowEfetadas = repository.AtualizaCliente(dados.idcliente(),dados.nome(),dados.sobrenome(),dados.endereco(),dados.email(),dados.telefone());

        if(rowEfetadas > 0){
            return  ResponseEntity.ok().body(dados);
        }
        return ResponseEntity.notFound().build();


    }

    @DeleteMapping("/Excluir/{id}")
    @Operation(tags = "Cliente")
    public ResponseEntity ExcluirCliente(@PathVariable Long id){
        try {
            var cliente = repository.getReferenceById(id);
            repository.delete(cliente);
            return  ResponseEntity.ok().body(cliente);
        }catch (Exception ex){
            return ResponseEntity.ok(ex.getStackTrace());
        }

    }


}
