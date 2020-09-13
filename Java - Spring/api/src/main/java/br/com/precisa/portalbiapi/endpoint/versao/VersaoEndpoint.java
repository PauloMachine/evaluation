package br.com.precisa.portalbiapi.endpoint.versao;

import br.com.precisa.portalbiapi.model.versao.Versao;
import br.com.precisa.portalbiapi.service.versao.VersaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("versao")
public class VersaoEndpoint {

    @Autowired
    private VersaoService versaoService;

    @GetMapping("graficoprojecaorecebimentos")
    public Versao findByContaBancariaPBI() {
        return versaoService.findGraficoProjecaoRecebimentos();
    }
}
