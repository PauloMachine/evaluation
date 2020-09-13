package br.com.precisa.portalbiapi.config.security.service.autenticacao;

import br.com.precisa.portalbiapi.config.security.service.token.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private TokenService tokenService;

    @PostMapping("logout")
    public ResponseEntity<?> logout(@RequestBody Map<String, Object> map) {

        String token = (String) map.get("sql/token");

        tokenService.insertBackList(token);

        return ResponseEntity.ok().build();
    }

}
