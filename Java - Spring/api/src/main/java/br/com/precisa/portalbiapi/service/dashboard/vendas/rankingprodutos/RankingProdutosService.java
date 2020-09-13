package br.com.precisa.portalbiapi.service.dashboard.vendas.rankingprodutos;

import br.com.precisa.portalbiapi.model.dashboard.vendas.rankingprodutos.RankingProdutos;
import br.com.precisa.portalbiapi.repository.dashboard.vendas.rankingprodutos.RankingProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankingProdutosService {

    @Autowired
    private RankingProdutosRepository rankingProdutosRepository;

    public List<RankingProdutos> find(String idEmpresa, String ordenacao, String dataInicial, String dataFinal, Long iPage, Long iSize) {
        return rankingProdutosRepository.find(idEmpresa, ordenacao, dataInicial, dataFinal, iPage, iSize);
    }

    public int countAll(String idEmpresa, String dataInicial, String dataFinal) {
        return rankingProdutosRepository.countAll(idEmpresa, dataInicial, dataFinal);
    }

}
