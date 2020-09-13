package br.com.precisa.portalbiapi.endpoint.dashboard.vendas.rankingsecoes;

import br.com.precisa.portalbiapi.model.dashboard.vendas.rankingsecoes.RankingSecoes;
import br.com.precisa.portalbiapi.service.dashboard.vendas.rankingsecoes.RankingSecoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("rankingsecoes")
public class RankingSecoesEndpoint {

    @Autowired
    private RankingSecoesService rankingSecoesService;

    @GetMapping("")
    public ResponseEntity<List<RankingSecoes>> find(@RequestParam("empresa") String idEmpresa,
                                                    @RequestParam("ordenacao") String ordenacao,
                                                    @RequestParam("dataInicial") String dataInicial,
                                                    @RequestParam("dataFinal") String dataFinal,
                                                    @RequestParam("page") Long page,
                                                    @RequestParam("size") Long size) {


        Long iPage = (page == 0 ? 1 : page);
        Long iSize = (size == 0 ? 5 : size);

        int totalRegistros = rankingSecoesService.countAll(idEmpresa, dataInicial, dataFinal);

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("X-Record-Count", String.valueOf(totalRegistros));

        if (totalRegistros == 0) {
            return ResponseEntity.noContent().headers(responseHeaders).build();
        }

        List<RankingSecoes> rankingSecoes = rankingSecoesService.find(idEmpresa, ordenacao, dataInicial, dataFinal, iPage, iSize);

        if (rankingSecoes.size() == 0) {
            return ResponseEntity.noContent().headers(responseHeaders).build();
        }

        return ResponseEntity.ok().headers(responseHeaders).body(rankingSecoes);
    }
}
