package br.com.precisa.portalbiapi.mapper.dashboard.vendas.rankingsecoes;

import br.com.precisa.portalbiapi.model.dashboard.vendas.rankingsecoes.RankingSecoes;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RankingSecoesRowMapper implements RowMapper<RankingSecoes> {

    @Override
    public RankingSecoes mapRow(ResultSet resultSet, int i) throws SQLException {

        RankingSecoes rankingSecoes = new RankingSecoes();

        rankingSecoes.setNomeSecao(resultSet.getString("SECAO"));
        rankingSecoes.setCusto(resultSet.getDouble("CUSTO"));
        rankingSecoes.setLucro(resultSet.getDouble("LUCRO"));
        rankingSecoes.setFaturamento(resultSet.getDouble("FATURAMENTO"));
        rankingSecoes.setQtdVendida(resultSet.getInt("QUANTIDADE"));

        return rankingSecoes;
    }
}
