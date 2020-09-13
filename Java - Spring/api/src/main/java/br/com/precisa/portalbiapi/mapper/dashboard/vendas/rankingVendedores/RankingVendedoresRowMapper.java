package br.com.precisa.portalbiapi.mapper.dashboard.vendas.rankingVendedores;

import br.com.precisa.portalbiapi.model.dashboard.vendas.rankingVendedores.RankingVendedores;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RankingVendedoresRowMapper implements RowMapper<RankingVendedores> {

    @Override
    public RankingVendedores mapRow(ResultSet resultSet, int i) throws SQLException {

        RankingVendedores rankingVendedores = new RankingVendedores();

        rankingVendedores.setNomeVendedor(resultSet.getString("VENDEDOR"));
        rankingVendedores.setCusto(resultSet.getDouble("CUSTO"));
        rankingVendedores.setLucro(resultSet.getDouble("LUCRO"));
        rankingVendedores.setFaturamento(resultSet.getDouble("FATURAMENTO"));
        rankingVendedores.setQtdVendida(resultSet.getInt("QUANTIDADE"));

        return rankingVendedores;
    }
}
