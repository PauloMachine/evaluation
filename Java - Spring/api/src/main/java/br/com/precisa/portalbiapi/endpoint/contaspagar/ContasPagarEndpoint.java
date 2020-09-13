package br.com.precisa.portalbiapi.endpoint.contaspagar;

import br.com.precisa.portalbiapi.model.contaspagar.ContasPagar;
import br.com.precisa.portalbiapi.service.contaspagar.ContasPagarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.format.DateTimeParseException;
import java.util.List;

@RestController
@RequestMapping("contaspagar")
public class ContasPagarEndpoint {

    @Autowired
    ContasPagarService contasPagarService;

    @GetMapping("")
    public List<ContasPagar> findAll() {
        return contasPagarService.findAll();
    }

    @PostMapping("")
    public ResponseEntity<?> InsertOrUpdate(@RequestBody ContasPagar contasPagar,
            UriComponentsBuilder uriComponentsBuilder) {

        try {
            contasPagarService.InsertOrUpdate(contasPagar);
        } catch (DateTimeParseException e) {
            return ResponseEntity.status(450).build();
        }

        URI uri = uriComponentsBuilder.path("/contaspagar").buildAndExpand(contasPagar.getIdPag()).toUri();
        return ResponseEntity.created(uri).body(contasPagar);
    }

    @PutMapping("{idPag}")
    public void updateById(@PathVariable("idPag") Long idPag) {
        contasPagarService.updateById(idPag);
    }

    @GetMapping("{idPag}")
    public ContasPagar findById(@PathVariable("idPag") Long idPag) {
        return contasPagarService.findById(idPag);
    }

    @DeleteMapping("{idPag}")
    public ResponseEntity deleteById(@PathVariable("idPag") Long idConta) {

        ResponseEntity responseEntity;

        boolean deleted = contasPagarService.deleteById(idConta);
        if (deleted) {
            responseEntity = ResponseEntity.ok().build();
        } else {
            responseEntity = ResponseEntity.notFound().build();
        }
        return responseEntity;
    }
}
