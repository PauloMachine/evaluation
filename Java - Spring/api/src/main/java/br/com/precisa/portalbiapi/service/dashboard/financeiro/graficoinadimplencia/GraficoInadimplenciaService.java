package br.com.precisa.portalbiapi.service.dashboard.financeiro.graficoinadimplencia;

import br.com.precisa.portalbiapi.model.dashboard.financeiro.graficoinadimplencia.GraficoInadimplencia;
import br.com.precisa.portalbiapi.repository.dashboard.financeiro.graficoinadimplencia.GraficoInadimplenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GraficoInadimplenciaService {

    @Autowired
    private GraficoInadimplenciaRepository graficoInadimplenciaRepository;

    public List<GraficoInadimplencia> findById(String idEmpresa, String dataInicial, String dataFinal) {
        return graficoInadimplenciaRepository.findByIdEmpresa(idEmpresa, dataInicial, dataFinal);
    }
}
