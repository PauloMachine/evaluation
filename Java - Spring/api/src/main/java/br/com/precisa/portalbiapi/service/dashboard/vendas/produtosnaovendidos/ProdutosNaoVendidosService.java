package br.com.precisa.portalbiapi.service.dashboard.vendas.produtosnaovendidos;

import br.com.precisa.portalbiapi.model.dashboard.vendas.produtosnaovendidos.ProdutosNaoVendidos;
import br.com.precisa.portalbiapi.repository.dashboard.vendas.produtosnaovendidos.ProdutosNaoVendidosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutosNaoVendidosService {

    @Autowired
    private ProdutosNaoVendidosRepository produtosNaoVendidosRepository;

    public List<ProdutosNaoVendidos> findById(String idEmpresa, Integer periodo, String ordenacao, Long iPage,
            Long iSize) {
        return produtosNaoVendidosRepository.findById(idEmpresa, periodo, ordenacao, iPage, iSize);
    }

    public int countAll(String idEmpresa, Integer periodo) {
        return produtosNaoVendidosRepository.countAll(idEmpresa, periodo);
    }
}
