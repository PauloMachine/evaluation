package br.com.precisa.portalbiapi.endpoint.dashboard.financeiro.duplicatas;

import br.com.precisa.portalbiapi.model.dashboard.financeiro.duplicatas.Duplicatas;
import br.com.precisa.portalbiapi.service.dashboard.financeiro.duplicatas.DuplicatasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("duplicatas")
public class DuplicatasEndpoint {

    @Autowired
    private DuplicatasService duplicatasService;

    @GetMapping("")
    public ResponseEntity<List<Duplicatas>> findById(@RequestParam("empresa") String idEmpresa,
                                                     @RequestParam("page") Long page,
                                                     @RequestParam("size") Long size,
                                                     @RequestParam("dataInicial") String dataInicial,
                                                     @RequestParam("dataFinal") String dataFinal) {

        Long iPage = (page == 0 ? 1 : page);
        Long iSize = (size == 0 ? 5 : size);

        long totalRegistros = duplicatasService.findAllCount(idEmpresa, dataInicial, dataFinal);
        double totalSaldo = duplicatasService.findAllSum(idEmpresa, dataInicial, dataFinal);

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("X-Record-Count", String.valueOf(totalRegistros));
        responseHeaders.set("X-Record-Sum", String.valueOf(totalSaldo));

        if (totalRegistros == 0) {
            return ResponseEntity.noContent().headers(responseHeaders).build();
        }

        if (totalSaldo == 0) {
            return ResponseEntity.noContent().headers(responseHeaders).build();
        }

        List<Duplicatas> duplicatas = duplicatasService.findById(idEmpresa, iPage, iSize, dataInicial, dataFinal);

        if (duplicatas.size() == 0) {
            return ResponseEntity.noContent().headers(responseHeaders).build();
        }

        return ResponseEntity.ok().headers(responseHeaders).body(duplicatas);
    }
}
