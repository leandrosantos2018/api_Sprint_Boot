package manager.gm.api.domain.repository;

import manager.gm.api.domain.models.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    UserDetails findByLogin(String login);
    

    @Query("""
            select count(*) > 0 from Usuario u where u.login=:login
            """)
    boolean UsuarioExiste(String  login);

    @Query("""
            select u.id, u.login, u.Senha from Usuario u where login=:login
            """)
    Usuario findUsuario (String login);


    @Query("""
            update Usuario u set Senha=:senha where login=:login
                        
            """)
    @Modifying
    int alteraSenha(String login , String senha);
}
