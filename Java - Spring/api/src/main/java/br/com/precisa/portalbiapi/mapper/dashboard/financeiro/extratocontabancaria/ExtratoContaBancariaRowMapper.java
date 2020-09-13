package br.com.precisa.portalbiapi.mapper.dashboard.financeiro.extratocontabancaria;

import br.com.precisa.portalbiapi.model.dashboard.financeiro.extratocontabancaria.ExtratoContaBancaria;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExtratoContaBancariaRowMapper implements RowMapper<ExtratoContaBancaria> {

    @Override
    public ExtratoContaBancaria mapRow(ResultSet resultSet, int i) throws SQLException {

        ExtratoContaBancaria extratoContaBancaria = new ExtratoContaBancaria();

        extratoContaBancaria.setTipoTotal(resultSet.getLong("TIPOTOTAL"));
        extratoContaBancaria.setCredito(resultSet.getDouble("CREDITO"));
        extratoContaBancaria.setDebito(resultSet.getDouble("DEBITO"));
        extratoContaBancaria.setSaldo(resultSet.getDouble("SALDO"));
        extratoContaBancaria.setComplemento(resultSet.getString("COMPLEMENTO"));
        extratoContaBancaria.setHistorico(resultSet.getString("HISTORICO"));

        //Tratamento para data nula
        if(resultSet.getDate("DATALANC") != null) {
            extratoContaBancaria.setDataLanc(resultSet.getDate("DATALANC").toLocalDate());
        }

        return extratoContaBancaria;
    }
}
