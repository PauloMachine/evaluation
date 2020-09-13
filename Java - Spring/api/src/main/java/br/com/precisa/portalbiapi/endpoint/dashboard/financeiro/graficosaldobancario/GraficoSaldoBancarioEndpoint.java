package br.com.precisa.portalbiapi.endpoint.dashboard.financeiro.graficosaldobancario;

import br.com.precisa.portalbiapi.model.dashboard.financeiro.graficosaldobancario.GraficoSaldoBancario;
import br.com.precisa.portalbiapi.service.dashboard.financeiro.graficosaldobancario.GraficoSaldoBancarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("graficosaldobancario")
public class GraficoSaldoBancarioEndpoint {

    @Autowired
    private GraficoSaldoBancarioService graficoSaldoBancarioService;

    @GetMapping("")
    public List<GraficoSaldoBancario> findById(@RequestParam("empresa") String idEmpresa,
                                               @RequestParam("dataInicial") String dataInicial,
                                               @RequestParam("dataFinal") String dataFinal) {

        return graficoSaldoBancarioService.findById(idEmpresa, dataInicial, dataFinal);
    }
}
