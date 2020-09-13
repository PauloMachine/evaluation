package br.com.precisa.portalbiapi.mapper.dashboard.financeiro.duplicatas;

import br.com.precisa.portalbiapi.model.dashboard.financeiro.duplicatas.Duplicatas;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DuplicatasRowMapper implements RowMapper<Duplicatas> {

    @Override
    public Duplicatas mapRow(ResultSet resultSet, int i) throws SQLException {

        Duplicatas duplicatas = new Duplicatas();

        duplicatas.setIdCliente(resultSet.getLong("IDCLIENTE"));
        duplicatas.setCredito(resultSet.getDouble("CREDITO"));
        duplicatas.setEmissao(resultSet.getDate("EMISSAO").toLocalDate());
        duplicatas.setDupl(resultSet.getLong("DUPL"));
        duplicatas.setNota(resultSet.getLong("NOTA"));
        duplicatas.setParcela(resultSet.getLong("PARCELA"));
        duplicatas.setSaldo(resultSet.getDouble("SALDO"));
        duplicatas.setValor(resultSet.getDouble("VALOR"));
        duplicatas.setVcto(resultSet.getDate("VCTO").toLocalDate());
        duplicatas.setRazao(resultSet.getString("RAZAO"));

        return duplicatas;
    }
}
