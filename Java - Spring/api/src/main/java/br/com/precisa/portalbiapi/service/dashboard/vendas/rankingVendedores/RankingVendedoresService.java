package br.com.precisa.portalbiapi.service.dashboard.vendas.rankingVendedores;

import br.com.precisa.portalbiapi.model.dashboard.vendas.rankingVendedores.RankingVendedores;
import br.com.precisa.portalbiapi.repository.dashboard.vendas.rankingvendedores.RankingVendedoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankingVendedoresService {

    @Autowired
    private RankingVendedoresRepository rankingVendedoresRepository;

    public List<RankingVendedores> find(String idEmpresa, String ordenacao, String dataInicial, String dataFinal, Long iPage, Long iSize) {
        return rankingVendedoresRepository.find(idEmpresa, ordenacao, dataInicial, dataFinal, iPage, iSize);
    }

    public int countAll(String idEmpresa, String dataInicial, String dataFinal) {
        return rankingVendedoresRepository.countAll(idEmpresa, dataInicial, dataFinal);
    }

}
