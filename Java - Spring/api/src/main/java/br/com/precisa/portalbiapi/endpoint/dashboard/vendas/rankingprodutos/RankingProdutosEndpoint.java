package br.com.precisa.portalbiapi.endpoint.dashboard.vendas.rankingprodutos;

import br.com.precisa.portalbiapi.model.dashboard.vendas.rankingprodutos.RankingProdutos;
import br.com.precisa.portalbiapi.service.dashboard.vendas.rankingprodutos.RankingProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("rankingprodutos")
public class RankingProdutosEndpoint {

    @Autowired
    private RankingProdutosService rankingProdutosService;

    @GetMapping("")
    public ResponseEntity<List<RankingProdutos>> find(@RequestParam("empresa") String idEmpresa,
            @RequestParam("ordenacao") String ordenacao, @RequestParam("dataInicial") String dataInicial,
            @RequestParam("dataFinal") String dataFinal, @RequestParam("page") Long page,
            @RequestParam("size") Long size) {

        Long iPage = (page == 0 ? 1 : page);
        Long iSize = (size == 0 ? 5 : size);

        int totalRegistros = rankingProdutosService.countAll(idEmpresa, dataInicial, dataFinal);

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("X-Record-Count", String.valueOf(totalRegistros));

        if (totalRegistros == 0) {
            return ResponseEntity.noContent().headers(responseHeaders).build();
        }

        List<RankingProdutos> rankingProdutos = rankingProdutosService.find(idEmpresa, ordenacao, dataInicial,
                dataFinal, iPage, iSize);

        if (rankingProdutos.size() == 0) {
            return ResponseEntity.noContent().headers(responseHeaders).build();
        }

        return ResponseEntity.ok().headers(responseHeaders).body(rankingProdutos);
    }

}
