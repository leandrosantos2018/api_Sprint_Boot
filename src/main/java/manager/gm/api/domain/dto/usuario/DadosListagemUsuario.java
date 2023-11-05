package manager.gm.api.domain.dto.usuario;

public record DadosListagemUsuario(String Login) {

    public static record DadosAutenticacaoUsuario(String Login, String Senha) {

    }
}
