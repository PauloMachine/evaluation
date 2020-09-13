package br.com.precisa.portalbiapi.model.usuario;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
public class Usuario implements UserDetails {

    /**
     *
     */
    private static final long serialVersionUID = 1919431697777936971L;
    private Long idUsuario;
    private String login;
    private String password;
    private String nome;

    @JsonIgnore
    private String refreshToken;

    @JsonIgnore
    private List<Perfil> perfis = new ArrayList<>();

    public Usuario() {
        this.perfis.add(new Perfil());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.perfis;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
