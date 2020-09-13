package br.com.precisa.portalbiapi.endpoint.resumocontas;

import br.com.precisa.portalbiapi.model.resumocontas.ResumoContas;
import br.com.precisa.portalbiapi.service.resumocontas.ResumoContasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("resumocontas")
public class ResumoContasEndpoint {

    @Autowired
    private ResumoContasService resumoContasService;

    @GetMapping("")
    public List<ResumoContas> findAll(@RequestParam("dataInicial") String dataInicial, @RequestParam("dataFinal") String dataFinal) {
        return resumoContasService.findAll(dataInicial, dataFinal);
    }

}
