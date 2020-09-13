package br.com.precisa.portalbiapi.mapper.dashboard.vendas.rankingprodutos;

import br.com.precisa.portalbiapi.model.dashboard.vendas.rankingprodutos.RankingProdutos;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RankingProdutosRowMapper implements RowMapper<RankingProdutos> {

    @Override
    public RankingProdutos mapRow(ResultSet resultSet, int i) throws SQLException {

        RankingProdutos rankingProdutos = new RankingProdutos();

        rankingProdutos.setNomeProduto(resultSet.getString("NOMEPRO"));
        rankingProdutos.setCusto(resultSet.getDouble("CUSTO"));
        rankingProdutos.setLucro(resultSet.getDouble("LUCRO"));
        rankingProdutos.setFaturamento(resultSet.getDouble("FATURAMENTO"));
        rankingProdutos.setQtdVendida(resultSet.getInt("QUANTIDADE"));

        return rankingProdutos;
    }
}
