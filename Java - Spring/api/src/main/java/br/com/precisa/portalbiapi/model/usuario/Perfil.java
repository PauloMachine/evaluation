package br.com.precisa.portalbiapi.model.usuario;

import org.springframework.security.core.GrantedAuthority;

public class Perfil implements GrantedAuthority {

    /**
     *
     */
    private static final long serialVersionUID = -664504028832861389L;

    @Override
    public String getAuthority() {
        return "admin";
    }
}
