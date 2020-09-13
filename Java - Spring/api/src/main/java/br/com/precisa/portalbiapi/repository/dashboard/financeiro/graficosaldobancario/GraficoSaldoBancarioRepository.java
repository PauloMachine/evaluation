package br.com.precisa.portalbiapi.repository.dashboard.financeiro.graficosaldobancario;

import br.com.precisa.portalbiapi.mapper.dashboard.financeiro.graficosaldobancario.GraficoSaldoBancarioRowMapper;
import br.com.precisa.portalbiapi.model.dashboard.financeiro.graficosaldobancario.GraficoSaldoBancario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class GraficoSaldoBancarioRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<GraficoSaldoBancario> findById(String idEmpresa, String dataInicial, String dataFinal) {

        List<GraficoSaldoBancario> graficoSaldoBancario;

        String sql = " SELECT  D_DATA DATA, N_SDOCTA SDOCTA, N_SDOPAGARDIA SDOPAGARDIA, N_SDOPAGARACUMULADO SDOPAGARACUMULADO " +
                " FROM FIN_SALDOCTASDUPL( '" + idEmpresa + "', '" + LocalDate.parse(dataInicial, DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "', '" + LocalDate.parse(dataFinal, DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "' ) ";

        Map<String, Object> params = new HashMap<>();

        graficoSaldoBancario = namedParameterJdbcTemplate.query(sql, params, new GraficoSaldoBancarioRowMapper());

        return graficoSaldoBancario;
    }

}
