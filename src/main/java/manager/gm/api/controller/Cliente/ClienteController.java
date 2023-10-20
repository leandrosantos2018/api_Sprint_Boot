package manager.gm.api.controller.Cliente;

import ch.qos.logback.core.net.server.Client;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import manager.gm.api.domain.Dto.cliente.DadosCadastrarCliente;
import manager.gm.api.domain.Models.cliente.Cliente;
import manager.gm.api.domain.Models.usuario.Usuario;
import manager.gm.api.domain.Repository.ClienteRepository;
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
    public ResponseEntity CadastrarCliente(@RequestBody @Valid DadosCadastrarCliente dados){

        if (dados != null){
            var cliente = new Cliente(dados.nome(),dados.sobrenome(),dados.endereco(),dados.email(),dados.telefone());

            repository.save(cliente);
            return  ResponseEntity.status(201).body("Cliente Cadastrado com Sucesso");
        }

        return ResponseEntity.ofNullable(dados);
    }

    @GetMapping("/Consulta")
    public List<Cliente> ListarCliente(@PageableDefault(size = 10, sort = {"nome"}) Pageable pagina){
        return repository.findAll();
    }

    @GetMapping("/Consulta/{id}")
    public List<Cliente> ListarClienteID(Long id){
        var cliente = repository.findAllById(Collections.singleton(id));

        return cliente;
    }

    @PutMapping("/Atualizar")
    @Transactional
    public ResponseEntity  ListarClienteID(@RequestBody DadosCadastrarCliente dados){

        int rowEfetadas = repository.AtualizaCliente(dados.idcliente(),dados.nome(),dados.sobrenome(),dados.endereco(),dados.email(),dados.telefone());

        if(rowEfetadas > 0){
            return  ResponseEntity.ok().body(dados);
        }
        return ResponseEntity.notFound().build();


    }
}
