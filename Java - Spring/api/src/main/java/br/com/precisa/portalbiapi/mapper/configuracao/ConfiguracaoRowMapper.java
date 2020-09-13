package br.com.precisa.portalbiapi.mapper.configuracao;

import br.com.precisa.portalbiapi.model.configuracao.Configuracao;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ConfiguracaoRowMapper implements RowMapper<Configuracao> {

    @Override
    public Configuracao mapRow(ResultSet resultSet, int i) throws SQLException {

        Configuracao configuracao = new Configuracao();

        configuracao.setIdCfg(resultSet.getInt("IDCFG"));
        configuracao.setDiasMaxAtraso(resultSet.getInt("DIASMAXATRASO"));
        configuracao.setNumeroDup(resultSet.getInt("NUMERODUP"));
        configuracao.setDesabilitarContas(resultSet.getInt("DESABILITARCONTAS"));
        configuracao.setInadimplenciaLimite(resultSet.getDouble("INADLIMITE"));
        configuracao.setMeioCobBloq(resultSet.getString("MEIOCOBBLOQ"));

        return configuracao;
    }
}
