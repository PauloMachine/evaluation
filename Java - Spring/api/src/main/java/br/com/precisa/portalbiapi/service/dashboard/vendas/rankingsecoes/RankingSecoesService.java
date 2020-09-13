package br.com.precisa.portalbiapi.service.dashboard.vendas.rankingsecoes;

import br.com.precisa.portalbiapi.model.dashboard.vendas.rankingsecoes.RankingSecoes;
import br.com.precisa.portalbiapi.repository.dashboard.vendas.rankingsecoes.RankingSecoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankingSecoesService {

    @Autowired
    private RankingSecoesRepository rankingSecoesRepository;

    public List<RankingSecoes> find(String idEmpresa, String ordenacao, String dataInicial, String dataFinal, Long iPage, Long iSize) {
        return rankingSecoesRepository.find(idEmpresa, ordenacao, dataInicial, dataFinal, iPage, iSize);
    }

    public int countAll(String idEmpresa, String dataInicial, String dataFinal) {
        return rankingSecoesRepository.countAll(idEmpresa, dataInicial, dataFinal);
    }
}
