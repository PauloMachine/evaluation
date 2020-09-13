package br.com.precisa.portalbiapi.service.usuario;

import br.com.precisa.portalbiapi.model.usuario.Usuario;
import br.com.precisa.portalbiapi.repository.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario findByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }

}
