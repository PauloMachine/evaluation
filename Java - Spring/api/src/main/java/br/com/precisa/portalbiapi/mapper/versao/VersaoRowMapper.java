package br.com.precisa.portalbiapi.mapper.versao;

import br.com.precisa.portalbiapi.model.versao.Versao;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VersaoRowMapper  implements RowMapper<Versao> {

    @Override
    public Versao mapRow(ResultSet resultSet, int i) throws SQLException {

        Versao versao = new Versao();

        versao.setVersaoTransmissao(resultSet.getLong("VERSAO_TRANSMISSAO"));
        versao.setDataTransmissao(resultSet.getDate("DATA_TRANSMISSAO").toLocalDate());
        versao.setHoraTransmissao(resultSet.getTime("HORA_TRANSMISSAO").toLocalTime());

        return versao;
    }
}
