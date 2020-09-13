package br.com.precisa.portalbiapi.mapper.contaspagar;

import br.com.precisa.portalbiapi.model.contaspagar.ContasPagar;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContasPagarRowMapper implements RowMapper<ContasPagar> {
    @Override

    public ContasPagar mapRow(ResultSet resultSet, int i) throws SQLException {

        ContasPagar contasPagar = new ContasPagar();

        contasPagar.setIdPag(resultSet.getLong("IDPAG"));
        contasPagar.setIdConta(resultSet.getLong("IDCONTA"));
        contasPagar.setValor(resultSet.getDouble("VALOR"));
        contasPagar.setNumero(resultSet.getLong("NUMERO"));
        contasPagar.setStsPgto(resultSet.getLong("STSPGTO"));
        contasPagar.setCor(resultSet.getString("COR"));
        contasPagar.setCorConta(resultSet.getString("CORCONTA"));
        contasPagar.setDtVcto(resultSet.getString("DTVCTO"));
        contasPagar.setNomeReduz(resultSet.getString("NOMEREDUZ"));
        contasPagar.setRazao(resultSet.getString("RAZAO"));
        contasPagar.setObservacao(resultSet.getString("OBSERVACAO"));

        return contasPagar;
    }

}
