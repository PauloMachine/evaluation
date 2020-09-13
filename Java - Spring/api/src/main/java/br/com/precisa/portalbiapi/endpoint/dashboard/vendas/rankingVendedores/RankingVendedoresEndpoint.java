package br.com.precisa.portalbiapi.endpoint.dashboard.vendas.rankingVendedores;

import br.com.precisa.portalbiapi.model.dashboard.vendas.rankingVendedores.RankingVendedores;
import br.com.precisa.portalbiapi.service.dashboard.vendas.rankingVendedores.RankingVendedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("rankingvendedores")
public class RankingVendedoresEndpoint {

    @Autowired
    private RankingVendedoresService rankingVendedoresService;

    @GetMapping("")
    public ResponseEntity<List<RankingVendedores>> find(@RequestParam("empresa") String idEmpresa,
                                                        @RequestParam("ordenacao") String ordenacao,
                                                        @RequestParam("dataInicial") String dataInicial,
                                                        @RequestParam("dataFinal") String dataFinal,
                                                        @RequestParam("page") Long page,
                                                        @RequestParam("size") Long size) {

        Long iPage = (page == 0 ? 1 : page);
        Long iSize = (size == 0 ? 5 : size);

        int totalRegistros = rankingVendedoresService.countAll(idEmpresa, dataInicial, dataFinal);

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("X-Record-Count", String.valueOf(totalRegistros));

        if (totalRegistros == 0) {
            return ResponseEntity.noContent().headers(responseHeaders).build();
        }

        List<RankingVendedores> rankingVendedores = rankingVendedoresService.find(idEmpresa, ordenacao, dataInicial, dataFinal, iPage, iSize);

        if (rankingVendedores.size() == 0) {
            return ResponseEntity.noContent().headers(responseHeaders).build();
        }

        return ResponseEntity.ok().headers(responseHeaders).body(rankingVendedores);
    }

}
