package br.com.precisa.portalbiapi.endpoint.contasbancarias;

import br.com.precisa.portalbiapi.model.contasbancarias.ContasBancarias;
import br.com.precisa.portalbiapi.service.contasbancarias.ContasBancariasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("contasbancarias")
public class ContasBancariasEndpoint {

    @Autowired
    private ContasBancariasService contasBancariasService;

    @GetMapping("")
    public List<ContasBancarias> findAll(@RequestParam("limiteCtb") Integer limiteCtb) {

        return contasBancariasService.findAll(limiteCtb);
    }

    @GetMapping("{idConta}")
    public ContasBancarias findById(@PathVariable("idConta") Integer idConta) {
        return contasBancariasService.findById(idConta);
    }

    @PostMapping("")
    public ResponseEntity<?> InsertOrUpdate(@RequestBody ContasBancarias contasBancarias,
            UriComponentsBuilder uriComponentsBuilder) {
        Integer validLimiteCtb = contasBancariasService.InsertOrUpdate(contasBancarias);

        if (validLimiteCtb == 1) {
            return ResponseEntity.status(450).build();
        }

        URI uri = uriComponentsBuilder.path("/contasbancarias").buildAndExpand(contasBancarias.getIdConta()).toUri();
        return ResponseEntity.created(uri).body(contasBancarias);
    }

    @DeleteMapping("{idConta}")
    public ResponseEntity deleteById(@PathVariable("idConta") Long idConta) {

        ResponseEntity responseEntity;

        boolean deleted = contasBancariasService.deleteById(idConta);
        if (deleted) {
            responseEntity = ResponseEntity.ok().build();
        } else {
            responseEntity = ResponseEntity.notFound().build();
        }
        return responseEntity;
    }

}
