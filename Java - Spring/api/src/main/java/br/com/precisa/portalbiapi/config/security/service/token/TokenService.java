package br.com.precisa.portalbiapi.config.security.service.token;

import br.com.precisa.portalbiapi.config.security.repository.token.TokenRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    @Autowired
    private TokenRepository tokenRepository;

    @Value("${jwt.expiration}")
    private String expirationTime;

    @Value("${jwt.secret}")
    private String secret;

    public boolean isTokenValido(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public Long getIdUsuario(String token) {
        Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return Long.parseLong(body.getSubject());
    }

    public void insertBackList(String token) {
        tokenRepository.insertBackList(token);
    }

    public boolean isInBackList(String token) {
        return tokenRepository.findInBlackList(token) != null;
    }
}
