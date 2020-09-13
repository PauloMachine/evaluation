package br.com.precisa.portalbiapi.mapper.dashboard.financeiro.graficoinadimplencia;

import br.com.precisa.portalbiapi.model.dashboard.financeiro.graficoinadimplencia.GraficoInadimplencia;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GraficoInadimplenciaRowMapper implements RowMapper<GraficoInadimplencia> {

    @Override
    public GraficoInadimplencia mapRow(ResultSet resultSet, int i) throws SQLException {

        GraficoInadimplencia graficoInadimplencia = new GraficoInadimplencia();

        graficoInadimplencia.setAno(resultSet.getLong("ANO"));
        graficoInadimplencia.setInadAtual(resultSet.getDouble("INAD_ATUAL"));
        graficoInadimplencia.setInadMes(resultSet.getDouble("INAD_MES"));
        graficoInadimplencia.setFaturamento(resultSet.getDouble("FATURAMENTO"));
        graficoInadimplencia.setMes(resultSet.getLong("MES"));

        return graficoInadimplencia;
    }
}
