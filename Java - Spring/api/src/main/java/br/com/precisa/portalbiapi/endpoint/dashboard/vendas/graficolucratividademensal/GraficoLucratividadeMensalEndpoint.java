package br.com.precisa.portalbiapi.endpoint.dashboard.vendas.graficolucratividademensal;

import br.com.precisa.portalbiapi.model.dashboard.vendas.graficolucratividademensal.GraficoLucratividadeMensal;
import br.com.precisa.portalbiapi.service.dashboard.vendas.graficolucratividademensal.GraficoLucratividadeMensalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("graficolucratividademensal")
public class GraficoLucratividadeMensalEndpoint {

    @Autowired
    private GraficoLucratividadeMensalService graficoLucratividadeMensalService;

    @GetMapping("")
    public List<GraficoLucratividadeMensal> findById(@RequestParam("empresa") String idEmpresa,
                                                     @RequestParam("dataInicial") String dataInicial,
                                                     @RequestParam("dataFinal") String dataFinal) {

        return graficoLucratividadeMensalService.findById(idEmpresa, dataInicial, dataFinal);
    }
}
