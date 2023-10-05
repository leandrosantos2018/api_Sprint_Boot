package manager.gm.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import manager.gm.api.domain.Dto.paciente.DadosListagemPaciente;
import manager.gm.api.domain.Dto.usuario.DadosCadastrarUsuario;
import manager.gm.api.domain.Dto.usuario.DadosListagemUsuario;
import manager.gm.api.domain.Models.usuario.Usuario;
import manager.gm.api.domain.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@Api(value = "Usuario Controller", description = "Operações relacionadas a usuários")
public class UsuarioController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UsuarioRepository repository;
    @PostMapping
    @ApiOperation(value = "Cadastrar um novo usuário")
    public ResponseEntity cadastrarUsuario(@RequestBody @Valid DadosCadastrarUsuario dados){

        if(!repository.UsuarioExiste(dados.Login())){
            var usuario = new Usuario(dados.Login(),passwordEncoder.encode(dados.Senha()) );
            repository.save(usuario);
            return ResponseEntity.ok(usuario);
        }

        return ResponseEntity.badRequest().body("Usuario já cadastrado");

    }
    @GetMapping
    @ApiOperation(value = "Lista Operadores")
    public Page<DadosListagemUsuario> ListarOperadores(@PageableDefault(size = 10, sort = {"Login"}) Pageable pagina){
        return repository.findAll(pagina).map(DadosListagemUsuario:: new);

    }




}
