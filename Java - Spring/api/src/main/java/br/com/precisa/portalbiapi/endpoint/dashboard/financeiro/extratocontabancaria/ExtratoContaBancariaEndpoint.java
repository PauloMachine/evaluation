package br.com.precisa.portalbiapi.endpoint.dashboard.financeiro.extratocontabancaria;

import br.com.precisa.portalbiapi.model.dashboard.financeiro.extratocontabancaria.ExtratoContaBancaria;
import br.com.precisa.portalbiapi.service.dashboard.financeiro.extratocontabancaria.ExtratoContaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("extratocontabancaria")
public class ExtratoContaBancariaEndpoint {

    @Autowired
    private ExtratoContaBancariaService extratoContaBancariaService;

    @GetMapping("")
    public List<ExtratoContaBancaria> findAll(@RequestParam("empresa") String idEmpresa,
                                              @RequestParam("idConta") Long idConta,
                                              @RequestParam("tipoLct") Long tipoLct,
                                              @RequestParam("diasLct") Long diasLct,
                                              @RequestParam("dataInicial") String dataInicial) {
        return extratoContaBancariaService.findById(idEmpresa, idConta, tipoLct, diasLct, dataInicial);
    }
}
