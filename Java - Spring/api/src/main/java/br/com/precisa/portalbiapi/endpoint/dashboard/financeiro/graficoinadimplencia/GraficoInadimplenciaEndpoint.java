package br.com.precisa.portalbiapi.endpoint.dashboard.financeiro.graficoinadimplencia;

import br.com.precisa.portalbiapi.model.dashboard.financeiro.graficoinadimplencia.GraficoInadimplencia;
import br.com.precisa.portalbiapi.service.dashboard.financeiro.graficoinadimplencia.GraficoInadimplenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("graficoinadimplencia")
public class GraficoInadimplenciaEndpoint {

    @Autowired
    private GraficoInadimplenciaService graficoInadimplenciaService;

    @GetMapping("")
    public List<GraficoInadimplencia> findById(@RequestParam("empresa") String idEmpresa,
                                               @RequestParam("dataInicial") String dataInicial,
                                               @RequestParam("dataFinal") String dataFinal) {

        return graficoInadimplenciaService.findById(idEmpresa, dataInicial, dataFinal);
    }
}
