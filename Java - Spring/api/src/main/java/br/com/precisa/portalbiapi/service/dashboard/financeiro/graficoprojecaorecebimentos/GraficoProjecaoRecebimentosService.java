package br.com.precisa.portalbiapi.service.dashboard.financeiro.graficoprojecaorecebimentos;

import br.com.precisa.portalbiapi.model.configuracao.Configuracao;
import br.com.precisa.portalbiapi.model.dashboard.financeiro.graficoprojecaorecebimentos.GraficoProjecaoRecebimentos;
import br.com.precisa.portalbiapi.repository.dashboard.financeiro.graficoprojecaorecebimentos.GraficoProjecaoRecebimentosRepository;
import br.com.precisa.portalbiapi.service.configuracao.ConfiguracaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@EnableScheduling
public class GraficoProjecaoRecebimentosService {

    @Autowired
    private GraficoProjecaoRecebimentosRepository graficoProjecaoRecebimentosRepository;

    @Autowired
    private ConfiguracaoService configuracaoService;

    @Scheduled(initialDelay = 30000, fixedDelay = 3600000)
    public void automaticReload() {
        Configuracao configuracao = configuracaoService.findAll();

        if (configuracao != null) {
            String meioCob = configuracao.getMeioCobBloq();
            Integer numeroDup = configuracao.getNumeroDup();
            Integer diasMaxAtraso = configuracao.getDiasMaxAtraso();

            String dataInicial = LocalDate.now().minusDays(30).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            String dataFinal = LocalDate.now().plusDays(30).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            graficoProjecaoRecebimentosRepository.rechargeAll(meioCob, numeroDup, diasMaxAtraso, dataInicial, dataFinal);
        }
    }

    public void forcedReload(String meioCob, Integer numeroDup, Integer diasMaxAtraso) {

            String dataInicial = LocalDate.now().minusDays(30).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            String dataFinal = LocalDate.now().plusDays(30).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            graficoProjecaoRecebimentosRepository.rechargeAll(meioCob, numeroDup, diasMaxAtraso, dataInicial, dataFinal);
    }

    public int findVersion() {
        return graficoProjecaoRecebimentosRepository.findVersion();
    }

    public List<GraficoProjecaoRecebimentos> findAll(String idEmpresa, Integer periodo) {

        Integer versao = findVersion();

        String dataInicial = LocalDate.now().minusDays(periodo).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String dataFinal = LocalDate.now().plusDays(periodo).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        return graficoProjecaoRecebimentosRepository.findAll(idEmpresa, dataInicial, dataFinal, versao);
    }
}
