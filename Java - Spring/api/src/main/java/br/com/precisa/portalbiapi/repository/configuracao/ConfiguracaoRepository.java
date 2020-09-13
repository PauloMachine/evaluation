package br.com.precisa.portalbiapi.repository.configuracao;

import br.com.precisa.portalbiapi.mapper.configuracao.ConfiguracaoRowMapper;
import br.com.precisa.portalbiapi.model.configuracao.Configuracao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ConfiguracaoRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Configuracao findAll() {

        Configuracao configuracao;
        Map<String, Object> params = new HashMap<>();

        String sql = " SELECT * " +
                     " FROM PBI_TBLCDSCFG0 ";

        try {
            configuracao = namedParameterJdbcTemplate.queryForObject(sql, params, new ConfiguracaoRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }

        return configuracao;
    }

    public void InsertOrUpdate(Configuracao configuracao) {
        //167491
        String sqlCfg0 = " UPDATE OR INSERT INTO PBI_TBLCDSCFG0 (IDCFG, DESABILITARCONTAS, INADLIMITE, MEIOCOBBLOQ, DIASMAXATRASO, NUMERODUP) " +
                         " VALUES (:IDCFG, :DESABILITARCONTAS, :INADLIMITE, :MEIOCOBBLOQ, :DIASMAXATRASO, :NUMERODUP) ";

        Map<String, Object> paramsCfg0 = new HashMap<>();
        paramsCfg0.put("IDCFG", configuracao.getIdCfg());
        paramsCfg0.put("DESABILITARCONTAS", configuracao.getDesabilitarContas());
        paramsCfg0.put("INADLIMITE", configuracao.getInadimplenciaLimite());
        paramsCfg0.put("MEIOCOBBLOQ", configuracao.getMeioCobBloq());
        paramsCfg0.put("DIASMAXATRASO", configuracao.getDiasMaxAtraso());
        paramsCfg0.put("NUMERODUP", configuracao.getNumeroDup());

        namedParameterJdbcTemplate.update(sqlCfg0, paramsCfg0);
    }
}
