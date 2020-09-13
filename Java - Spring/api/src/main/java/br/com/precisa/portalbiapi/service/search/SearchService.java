package br.com.precisa.portalbiapi.service.search;

import br.com.precisa.portalbiapi.model.search.Search;
import br.com.precisa.portalbiapi.repository.search.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    @Autowired
    private SearchRepository searchRepository;

    public List<Search> findByContaBancariaPBI() {
        return searchRepository.findByContaBancariaPBI();
    }

    public List<Search> findByContaBancariaSolution() {
        return searchRepository.findByContaBancariaSolution();
    }

    public List<Search> findByEmpresa(String search) {
        return searchRepository.findByEmpresa(search);
    }

    public List<Search> findAll() {
        return searchRepository.findAll();
    }
}
