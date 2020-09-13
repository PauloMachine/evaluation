package br.com.precisa.portalbiapi.service.dashboard.vendas.graficolucratividademensal;

import br.com.precisa.portalbiapi.model.dashboard.vendas.graficolucratividademensal.GraficoLucratividadeMensal;
import br.com.precisa.portalbiapi.repository.dashboard.vendas.graficolucratividademensal.GraficoLucratividadeMensalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GraficoLucratividadeMensalService {

    @Autowired
    private GraficoLucratividadeMensalRepository graficoLucratividadeMensalRepository;

    public List<GraficoLucratividadeMensal> findById(String idEmpresa, String dataInicial, String dataFinal) {
        return graficoLucratividadeMensalRepository.findById(idEmpresa, dataInicial, dataFinal);
    }
}
