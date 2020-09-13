package br.com.precisa.portalbiapi.mapper.dashboard.financeiro.graficoprojecaorecebimentos;

import br.com.precisa.portalbiapi.model.dashboard.financeiro.graficoprojecaorecebimentos.GraficoProjecaoRecebimentos;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GraficoProjecaoRecebimentosRowMapper implements RowMapper<GraficoProjecaoRecebimentos> {

    @Override
    public GraficoProjecaoRecebimentos mapRow(ResultSet resultSet, int i) throws SQLException {

        GraficoProjecaoRecebimentos graficoProjecaoRecebimentos = new GraficoProjecaoRecebimentos();


            graficoProjecaoRecebimentos.setData(resultSet.getDate("DATA").toLocalDate());
            graficoProjecaoRecebimentos.setDuplicataClientesBons(resultSet.getDouble("DUP_RECEBER_DIA_CLIENTES_BONS"));
            graficoProjecaoRecebimentos.setValorRecebidoDia(resultSet.getDouble("DUP_VLRECEBIDO_DIA"));
            graficoProjecaoRecebimentos.setDuplicataPagarDia(resultSet.getDouble("DUP_PAGAR_DIA"));
            graficoProjecaoRecebimentos.setChequePagarDia(resultSet.getDouble("CHE_PAGAR_DIA"));
            graficoProjecaoRecebimentos.setVersaoTransmissao(resultSet.getLong("VERSAO_TRANSMISSAO"));
            graficoProjecaoRecebimentos.setHoraTransmissao(resultSet.getTime("HORA_TRANSMISSAO").toLocalTime());
            graficoProjecaoRecebimentos.setDataTransmissao(resultSet.getDate("DATA_TRANSMISSAO").toLocalDate());

        return graficoProjecaoRecebimentos;
    }
}


