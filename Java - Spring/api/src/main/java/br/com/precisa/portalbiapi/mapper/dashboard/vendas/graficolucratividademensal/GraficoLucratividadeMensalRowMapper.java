package br.com.precisa.portalbiapi.mapper.dashboard.vendas.graficolucratividademensal;

import br.com.precisa.portalbiapi.model.dashboard.vendas.graficolucratividademensal.GraficoLucratividadeMensal;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GraficoLucratividadeMensalRowMapper implements RowMapper<GraficoLucratividadeMensal> {

    @Override
    public GraficoLucratividadeMensal mapRow(ResultSet resultSet, int i) throws SQLException {

        GraficoLucratividadeMensal graficoLucratividadeMensal = new GraficoLucratividadeMensal();

        graficoLucratividadeMensal.setAno(resultSet.getInt("ANO"));
        graficoLucratividadeMensal.setMes(resultSet.getInt("MES"));
        graficoLucratividadeMensal.setCusto(resultSet.getDouble("CUSTO"));
        graficoLucratividadeMensal.setLucroBruto(resultSet.getDouble("LUCROBRUTO"));
        graficoLucratividadeMensal.setFaturamento(resultSet.getDouble("FATURAMENTO"));

        return graficoLucratividadeMensal;
    }
}
