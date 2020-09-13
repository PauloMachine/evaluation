package br.com.precisa.portalbiapi.mapper.resumocontas;

import br.com.precisa.portalbiapi.model.resumocontas.ResumoContas;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResumoContasRowMapper implements RowMapper<ResumoContas> {

    @Override
    public ResumoContas mapRow(ResultSet resultSet, int i) throws SQLException {

        ResumoContas resumoContas = new ResumoContas();

        resumoContas.setIdPag(resultSet.getLong("R_ID"));
        resumoContas.setStsPgto(resultSet.getLong("R_PGTO"));
        resumoContas.setNumero(resultSet.getLong("R_NUMERO"));
        resumoContas.setRazao(resultSet.getString("R_RAZAO"));
        resumoContas.setFantasia(resultSet.getString("R_FANTASIA"));
        resumoContas.setConta(resultSet.getString("R_CONTA"));
        resumoContas.setObservacao(resultSet.getString("R_OBSERVACAO"));
        resumoContas.setTipo(resultSet.getString("R_TIPO"));
        resumoContas.setSaldo(resultSet.getDouble("R_SALDO"));

        //Caso não tenha cor na conta avulsa, é pego a cor da conta bancaria vinculada a ela
        if ((resultSet.getString("R_COR") == null) || (resultSet.getString("R_COR").equals(""))) {
            resumoContas.setCor(resultSet.getString("R_CORCTB"));
        } else {
            resumoContas.setCor(resultSet.getString("R_COR"));
        }

        //Tratamento para data nula
        if (resultSet.getDate("R_VCTO") != null) {
            resumoContas.setVcto(resultSet.getDate("R_VCTO").toLocalDate());
        }

        return resumoContas;
    }
}
