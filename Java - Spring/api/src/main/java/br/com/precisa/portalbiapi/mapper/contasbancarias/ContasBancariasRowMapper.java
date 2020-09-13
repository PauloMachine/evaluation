package br.com.precisa.portalbiapi.mapper.contasbancarias;

import br.com.precisa.portalbiapi.model.contasbancarias.ContasBancarias;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContasBancariasRowMapper implements RowMapper<ContasBancarias> {

    @Override
    public ContasBancarias mapRow(ResultSet resultSet, int i) throws SQLException {

        ContasBancarias consultaContasBancarias = new ContasBancarias();

        consultaContasBancarias.setIdConta(resultSet.getInt("IDCONTA"));
        consultaContasBancarias.setAgencia(resultSet.getString("AGENCIA"));
        consultaContasBancarias.setConta(resultSet.getString("CONTA"));
        consultaContasBancarias.setCor(resultSet.getString("COR"));
        consultaContasBancarias.setNome(resultSet.getString("NOMEREDUZ"));
        consultaContasBancarias.setNomeConta(resultSet.getString("NOMECONTA"));
        consultaContasBancarias.setLimite(resultSet.getDouble("LIMITE"));
        consultaContasBancarias.setStsSaldoAcu(resultSet.getInt("STSSALDOACU"));
        consultaContasBancarias.setStsSaldoInd(resultSet.getInt("STSSALDOIND"));

        if (resultSet.getString("IDCONTACTB") != null){
            consultaContasBancarias.setIdContaCtb(resultSet.getInt("IDCONTACTB"));
        }

        return consultaContasBancarias;
    }

}
