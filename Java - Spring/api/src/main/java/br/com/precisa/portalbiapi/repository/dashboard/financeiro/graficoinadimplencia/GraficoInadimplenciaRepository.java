package br.com.precisa.portalbiapi.repository.dashboard.financeiro.graficoinadimplencia;

import br.com.precisa.portalbiapi.mapper.dashboard.financeiro.graficoinadimplencia.GraficoInadimplenciaRowMapper;
import br.com.precisa.portalbiapi.model.dashboard.financeiro.graficoinadimplencia.GraficoInadimplencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class GraficoInadimplenciaRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<GraficoInadimplencia> findByIdEmpresa(String idEmpresa, String dataInicial, String dataFinal){

        List<GraficoInadimplencia> graficoInadimplencia;

        String sql = " SELECT MES, ANO, FATURAMENTO, INAD_ATUAL, INAD_MES " +
                     " FROM PBI_LOADINADIMPLENCIA ('" + idEmpresa + "', '" + LocalDate.parse(dataInicial, DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                     " ', '" + LocalDate.parse(dataFinal, DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "')";

        Map<String, Object> params = new HashMap<>();

        graficoInadimplencia = namedParameterJdbcTemplate.query(sql, params, new GraficoInadimplenciaRowMapper());

        return graficoInadimplencia;
    }
}
