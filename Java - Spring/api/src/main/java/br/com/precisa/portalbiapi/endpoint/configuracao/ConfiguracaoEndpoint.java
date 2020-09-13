package br.com.precisa.portalbiapi.endpoint.configuracao;

import br.com.precisa.portalbiapi.model.configuracao.Configuracao;
import br.com.precisa.portalbiapi.service.configuracao.ConfiguracaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("configuracao")
public class ConfiguracaoEndpoint {

    @Autowired
    private ConfiguracaoService configuracaoService;

    @GetMapping("")
    public Configuracao findAll() {
        return configuracaoService.findAll();
    }

    @PostMapping("")
    public ResponseEntity<?> InsertOrUpdate(@RequestBody Configuracao configuracao, UriComponentsBuilder uriComponentsBuilder) {
        configuracaoService.InsertOrUpdate(configuracao);

        URI uri = uriComponentsBuilder.path("/configuracoes").buildAndExpand(configuracao.getIdCfg()).toUri();
        return ResponseEntity.created(uri).body(configuracao);
    }
}
