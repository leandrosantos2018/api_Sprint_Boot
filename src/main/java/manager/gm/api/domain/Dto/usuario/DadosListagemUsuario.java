package manager.gm.api.domain.Dto.usuario;

import manager.gm.api.domain.Models.usuario.Usuario;

public record DadosListagemUsuario(String Login) {

    public static record DadosAutenticacaoUsuario(String Login, String Senha) {

    }
}
