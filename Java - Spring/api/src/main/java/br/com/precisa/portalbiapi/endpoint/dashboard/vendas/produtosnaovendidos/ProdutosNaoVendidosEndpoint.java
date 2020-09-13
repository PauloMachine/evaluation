package br.com.precisa.portalbiapi.endpoint.dashboard.vendas.produtosnaovendidos;

import br.com.precisa.portalbiapi.model.dashboard.vendas.produtosnaovendidos.ProdutosNaoVendidos;
import br.com.precisa.portalbiapi.service.dashboard.vendas.produtosnaovendidos.ProdutosNaoVendidosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("produtosnaovendidos")
public class ProdutosNaoVendidosEndpoint {

    @Autowired
    private ProdutosNaoVendidosService graficoDemonstrativoProdutosService;

    @GetMapping("")
    public ResponseEntity<List<ProdutosNaoVendidos>> findById(@RequestParam("empresa") String idEmpresa,
            @RequestParam("periodo") Integer periodo, @RequestParam("ordenacao") String ordenacao,
            @RequestParam("page") Long page, @RequestParam("size") Long size) {

        Long iPage = (page == 0 ? 1 : page);
        Long iSize = (size == 0 ? 5 : size);

        int totalRegistros = graficoDemonstrativoProdutosService.countAll(idEmpresa, periodo);

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("X-Record-Count", String.valueOf(totalRegistros));

        if (totalRegistros == 0) {
            return ResponseEntity.noContent().headers(responseHeaders).build();
        }

        List<ProdutosNaoVendidos> graficoDemonstrativoProdutos = graficoDemonstrativoProdutosService.findById(idEmpresa,
                periodo, ordenacao, iPage, iSize);

        if (graficoDemonstrativoProdutos.size() == 0) {
            return ResponseEntity.noContent().headers(responseHeaders).build();
        }

        return ResponseEntity.ok().headers(responseHeaders).body(graficoDemonstrativoProdutos);
    }
}
