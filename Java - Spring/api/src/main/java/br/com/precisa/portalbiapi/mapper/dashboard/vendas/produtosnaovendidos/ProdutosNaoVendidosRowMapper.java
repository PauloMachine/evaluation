package br.com.precisa.portalbiapi.mapper.dashboard.vendas.produtosnaovendidos;

import org.springframework.jdbc.core.RowMapper;

import br.com.precisa.portalbiapi.model.dashboard.vendas.produtosnaovendidos.ProdutosNaoVendidos;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutosNaoVendidosRowMapper implements RowMapper<ProdutosNaoVendidos> {

    @Override
    public ProdutosNaoVendidos mapRow(ResultSet resultSet, int i) throws SQLException {

        ProdutosNaoVendidos produtosNaoVendidos = new ProdutosNaoVendidos();

        produtosNaoVendidos.setIdItem(resultSet.getInt("IDITEM"));
        produtosNaoVendidos.setNomeProduto(resultSet.getString("NOMEPRO"));
        produtosNaoVendidos.setUndVen(resultSet.getString("UNDVEND1"));
        produtosNaoVendidos.setDtCad(resultSet.getDate("DTCAD").toLocalDate());
        produtosNaoVendidos.setUltVenda(resultSet.getDate("ULTVENDA").toLocalDate());
        produtosNaoVendidos.setSaldo(resultSet.getDouble("SALDO"));

        return produtosNaoVendidos;
    }

}
