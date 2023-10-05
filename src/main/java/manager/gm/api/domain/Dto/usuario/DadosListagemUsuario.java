package manager.gm.api.domain.Dto.usuario;

import manager.gm.api.domain.Models.usuario.Usuario;

public record DadosListagemUsuario(String Login) {
    public DadosListagemUsuario(Usuario usuario){
        this( usuario.getLogin());
    }
}