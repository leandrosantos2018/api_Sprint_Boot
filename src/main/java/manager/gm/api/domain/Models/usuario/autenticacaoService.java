package manager.gm.api.domain.Models.usuario;

import manager.gm.api.domain.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class autenticacaoService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repostory;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return repostory.findByLogin(username);
    }
}
