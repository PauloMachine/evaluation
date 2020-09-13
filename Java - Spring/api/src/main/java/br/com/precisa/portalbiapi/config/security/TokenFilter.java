package br.com.precisa.portalbiapi.config.security;

import br.com.precisa.portalbiapi.config.security.service.token.TokenService;
import br.com.precisa.portalbiapi.model.usuario.Usuario;
import br.com.precisa.portalbiapi.repository.usuario.UsuarioRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenFilter extends OncePerRequestFilter {

    private final String BEARER = "Bearer ";

    private TokenService tokenService;

    public TokenFilter(TokenService tokenService, UsuarioRepository usuarioRepository) {
        this.tokenService = tokenService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
            FilterChain filterChain) throws ServletException, IOException {

        String token = recuperaToken(httpServletRequest);

        boolean valido = tokenService.isTokenValido(token);

        if (valido) {
            autenticarUsuario(token);
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private void autenticarUsuario(String token) {

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = null;

        boolean inBackList = tokenService.isInBackList(token);

        if (!inBackList) {

            Long idUsuario = tokenService.getIdUsuario(token);

            Usuario usuario = new Usuario();

            usuario.setIdUsuario(idUsuario);
            usuario.setNome("Usuario");

            usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(usuario, null,
                    usuario.getPerfis());

        }

        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
    }

    private String recuperaToken(HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("Authorization");
        if (token == null || token.isEmpty() || !token.startsWith(BEARER)) {
            return null;
        }
        return token.substring(BEARER.length());
    }
}
