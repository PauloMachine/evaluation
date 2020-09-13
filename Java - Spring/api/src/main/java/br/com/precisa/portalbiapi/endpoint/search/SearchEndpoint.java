package br.com.precisa.portalbiapi.endpoint.search;

import br.com.precisa.portalbiapi.model.search.Search;
import br.com.precisa.portalbiapi.service.search.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("search")
public class SearchEndpoint {

    @Autowired
    private SearchService searchService;

    @GetMapping("contabancariapbi")
    public List<Search> findByContaBancariaPBI() {
        return searchService.findByContaBancariaPBI();
    }

    @GetMapping("contabancariasolution")
    public List<Search> findByContaBancariaSolution() {
        return searchService.findByContaBancariaSolution();
    }

    @GetMapping("empresa/{search}")
    public List<Search> findByEmpresa(@PathVariable("search") String search) {
        return searchService.findByEmpresa(search);
    }

    @GetMapping("empresa")
    public List<Search> findAll() {
        return searchService.findAll();
    }
}
