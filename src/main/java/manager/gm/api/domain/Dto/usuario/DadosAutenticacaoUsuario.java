package manager.gm.api.domain.Dto.usuario;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "dados de auenticacao")
public record DadosAutenticacaoUsuario(String Login, String Senha) {

}
