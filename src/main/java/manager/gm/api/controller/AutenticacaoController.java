package manager.gm.api.controller;


import jakarta.validation.Valid;
import manager.gm.api.domain.Dto.usuario.DadosListagemUsuario;
import manager.gm.api.domain.Models.usuario.Usuario;
import manager.gm.api.infra.security.DadosTokenJWT;
import manager.gm.api.infra.security.TokenServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")

public class AutenticacaoController {
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenServices tokenServices;

    @PostMapping

    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosListagemUsuario.DadosAutenticacaoUsuario dados) {
        try {
            var authenticationToken = new UsernamePasswordAuthenticationToken(dados.Login(), dados.Senha());
            var authentication = manager.authenticate(authenticationToken);

            var tokenJWT = tokenServices.GerarToker((Usuario) authentication.getPrincipal());

            return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
