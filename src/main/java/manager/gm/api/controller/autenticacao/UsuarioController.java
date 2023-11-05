package manager.gm.api.controller.autenticacao;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import manager.gm.api.domain.dto.usuario.DadosAlterarUsuario;
import manager.gm.api.domain.dto.usuario.DadosCadastrarUsuario;
import manager.gm.api.domain.models.usuario.Usuario;
import manager.gm.api.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("Usuario")
@RequestMapping("/usuario")

@SecurityRequirement(name = "bearer-key")

public class UsuarioController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UsuarioRepository repository;
    @PostMapping("cadastrar")
    @Operation(tags = "Usuario")
    public ResponseEntity cadastrarUsuario(@RequestBody @Valid DadosCadastrarUsuario dados){

        if(!repository.UsuarioExiste(dados.Login())){
            var usuario = new Usuario(dados.Login(),passwordEncoder.encode(dados.Senha()));

            repository.save(usuario);
            return ResponseEntity.status(201).body("Usuario Cacadstrado com Sucesso!!");
        }

        return ResponseEntity.badRequest().body("Usuario já cadastrado");

    }
   @GetMapping("Consulta")
   @Operation(tags = "Usuario")

    public List<Usuario> ListarOperadores(@PageableDefault(size = 10, sort = {"Login"}) Pageable pagina){
        return repository.findAll();

    }
    @DeleteMapping("Excluir/{id}")
    @Operation(tags = "Usuario")
   // @RequestMapping(value = "/Excluir/{id}", method = RequestMethod.DELETE)
    public  void excluirUsuario(@PathVariable Long Id){

    }


    @PutMapping("AlterarSenha")
    @Operation(tags = "Usuario")
    public ResponseEntity AlterarSenha(@RequestBody @Valid DadosAlterarUsuario dados){
            var usuario = repository.findByLogin(dados.Login());

            repository.alteraSenha(usuario.getUsername(), passwordEncoder.encode(dados.Senha()));
            var registroafetado = ResponseEntity.status(201).body("Senha Alterada com Sucesso!");

        return ResponseEntity.badRequest().build();


    }




}
