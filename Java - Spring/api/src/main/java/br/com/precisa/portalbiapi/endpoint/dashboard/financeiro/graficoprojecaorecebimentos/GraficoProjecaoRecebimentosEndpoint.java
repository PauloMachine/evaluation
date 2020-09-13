package br.com.precisa.portalbiapi.endpoint.dashboard.financeiro.graficoprojecaorecebimentos;

import br.com.precisa.portalbiapi.model.dashboard.financeiro.graficoprojecaorecebimentos.GraficoProjecaoRecebimentos;
import br.com.precisa.portalbiapi.service.dashboard.financeiro.graficoprojecaorecebimentos.GraficoProjecaoRecebimentosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("graficoprojecaorecebimentos")
public class GraficoProjecaoRecebimentosEndpoint {

    @Autowired
    private GraficoProjecaoRecebimentosService graficoProjecaoRecebimentosService;

    @GetMapping("")
    public List<GraficoProjecaoRecebimentos> findAll(@RequestParam("empresa") String idEmpresa,
                                                     @RequestParam("periodo") Integer periodo) {
        return graficoProjecaoRecebimentosService.findAll(idEmpresa, periodo);
    }

    @GetMapping("versao")
    public int findVersion() {
        return graficoProjecaoRecebimentosService.findVersion();
    }

    @GetMapping("recarregar")
    public void forcedReload(@RequestParam("meioCobBloq") String meioCob,
                             @RequestParam("numeroDup") Integer numeroDup,
                             @RequestParam("diasMaxAtraso") Integer diasMaxAtraso) {

       graficoProjecaoRecebimentosService.forcedReload(meioCob, numeroDup, diasMaxAtraso);
    }
}
