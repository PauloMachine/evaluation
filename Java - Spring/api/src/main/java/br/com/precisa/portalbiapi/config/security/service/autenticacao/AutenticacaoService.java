package br.com.precisa.portalbiapi.config.security.service.autenticacao;

import br.com.precisa.portalbiapi.model.usuario.Usuario;
import br.com.precisa.portalbiapi.service.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        Usuario usuario = usuarioService.findByLogin(login);

        if (usuario != null) {
            return usuario;
        }

        throw new UsernameNotFoundException("Usuário ou senha inválidos");
    }
}
