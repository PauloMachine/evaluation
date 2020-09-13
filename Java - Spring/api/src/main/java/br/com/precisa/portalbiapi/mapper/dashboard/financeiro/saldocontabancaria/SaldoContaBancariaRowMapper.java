package br.com.precisa.portalbiapi.mapper.dashboard.financeiro.saldocontabancaria;

import br.com.precisa.portalbiapi.model.dashboard.financeiro.saldocontabancaria.SaldoContaBancaria;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SaldoContaBancariaRowMapper implements RowMapper<SaldoContaBancaria> {

    @Override
    public SaldoContaBancaria mapRow(ResultSet resultSet, int i) throws SQLException {

        SaldoContaBancaria saldoContaBancaria = new SaldoContaBancaria();

        saldoContaBancaria.setIdConta(resultSet.getLong("IDCONTA"));
        saldoContaBancaria.setClassificacao(resultSet.getString("CLASSIFICACAO"));
        saldoContaBancaria.setCor(resultSet.getString("COR"));
        saldoContaBancaria.setNomeConta(resultSet.getString("NOMECONTA"));
        saldoContaBancaria.setSaldo(resultSet.getDouble("SALDO"));
        saldoContaBancaria.setLimite(resultSet.getString("LIMITE"));

        return saldoContaBancaria;
    }
}
