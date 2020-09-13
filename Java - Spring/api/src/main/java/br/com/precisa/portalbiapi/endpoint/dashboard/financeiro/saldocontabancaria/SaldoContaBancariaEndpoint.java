package br.com.precisa.portalbiapi.endpoint.dashboard.financeiro.saldocontabancaria;

import br.com.precisa.portalbiapi.model.dashboard.financeiro.saldocontabancaria.SaldoContaBancaria;
import br.com.precisa.portalbiapi.service.dashboard.financeiro.saldocontabancaria.SaldoContaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("saldocontabancaria")
public class SaldoContaBancariaEndpoint {

    @Autowired
    private SaldoContaBancariaService saldoContaBancariaService;

    @GetMapping("")
    public List<SaldoContaBancaria> findById(@RequestParam("empresa") String idEmpresa,
                                             @RequestParam("dataInicial") String dataInicial) {
        return saldoContaBancariaService.findById(idEmpresa, dataInicial);
    }
}
