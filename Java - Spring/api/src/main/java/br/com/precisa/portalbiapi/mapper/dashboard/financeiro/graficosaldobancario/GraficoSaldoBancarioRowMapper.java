package br.com.precisa.portalbiapi.mapper.dashboard.financeiro.graficosaldobancario;

import br.com.precisa.portalbiapi.model.dashboard.financeiro.graficosaldobancario.GraficoSaldoBancario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GraficoSaldoBancarioRowMapper implements RowMapper<GraficoSaldoBancario> {

    @Override
    public GraficoSaldoBancario mapRow(ResultSet resultSet, int i) throws SQLException {

        GraficoSaldoBancario graficoSaldoBancario = new GraficoSaldoBancario();

        graficoSaldoBancario.setData(resultSet.getDate("DATA").toLocalDate());
        graficoSaldoBancario.setSaldoPagarDia(resultSet.getDouble("SDOPAGARDIA"));
        graficoSaldoBancario.setSaldoCta(resultSet.getDouble("SDOCTA"));
        graficoSaldoBancario.setSaldoPagarAcumulado(resultSet.getDouble("SDOPAGARACUMULADO"));

        return graficoSaldoBancario;
    }
}
