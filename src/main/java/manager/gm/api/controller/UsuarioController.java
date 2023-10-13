package manager.gm.api.controller;


import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import manager.gm.api.domain.Dto.usuario.DadosCadastrarUsuario;
import manager.gm.api.domain.Models.usuario.Usuario;
import manager.gm.api.domain.Repository.UsuarioRepository;
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
    public ResponseEntity cadastrarUsuario(@RequestBody @Valid DadosCadastrarUsuario dados){

        if(!repository.UsuarioExiste(dados.Login())){
            var usuario = new Usuario(dados.Login(),passwordEncoder.encode(dados.Senha()));

            repository.save(usuario);
            return ResponseEntity.ok(usuario);
        }

        return ResponseEntity.badRequest().body("Usuario já cadastrado");

    }
   @GetMapping("Consulta")

    public List<Usuario> ListarOperadores(@PageableDefault(size = 10, sort = {"Login"}) Pageable pagina){
        return repository.findAll();

    }
    @DeleteMapping("Excluir/{id}")
   // @RequestMapping(value = "/Excluir/{id}", method = RequestMethod.DELETE)

    public  void exCluirUsuario(DadosCadastrarUsuario dados){




    }




}
