package br.com.precisa.portalbiapi.service.dashboard.financeiro.graficosaldobancario;

import br.com.precisa.portalbiapi.model.dashboard.financeiro.graficosaldobancario.GraficoSaldoBancario;
import br.com.precisa.portalbiapi.repository.dashboard.financeiro.graficosaldobancario.GraficoSaldoBancarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GraficoSaldoBancarioService {

    @Autowired
    private GraficoSaldoBancarioRepository graficoSaldoBancarioRepository;

    public List<GraficoSaldoBancario> findById(String idEmpresa, String dataInicial, String dataFinal) {
        return graficoSaldoBancarioRepository.findById(idEmpresa, dataInicial, dataFinal);
    }
}
