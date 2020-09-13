package br.com.precisa.portalbiapi.mapper.dashboard.vendas.ticketmedio;

import br.com.precisa.portalbiapi.model.dashboard.vendas.ticketmedio.TicketMedio;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketMedioRowMapper implements RowMapper<TicketMedio> {

    @Override
    public TicketMedio mapRow(ResultSet resultSet, int i) throws SQLException {

        TicketMedio ticketMedio = new TicketMedio();

        ticketMedio.setTotalVendas(resultSet.getInt("TOTALVENDAS"));
        ticketMedio.setQtdVendida(resultSet.getDouble("QTDVENDIDA"));
        ticketMedio.setQtdProduto(resultSet.getDouble("QTDPRODUTO"));
        ticketMedio.setQtdProdutoVen(resultSet.getDouble("QTDPRODUTOVEN"));
        ticketMedio.setFaturamento(resultSet.getDouble("FATURAMENTO"));

        return ticketMedio;
    }
}
