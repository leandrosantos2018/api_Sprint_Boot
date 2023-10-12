package manager.gm.api.domain.Repository;

import manager.gm.api.domain.Dto.usuario.DadosCadastrarUsuario;
import manager.gm.api.domain.Models.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    UserDetails findByLogin(String login);

    @Query("""
            select count(*) > 0 from Usuario u where u.login=:login
            """)
    boolean UsuarioExiste(String  login);


}
