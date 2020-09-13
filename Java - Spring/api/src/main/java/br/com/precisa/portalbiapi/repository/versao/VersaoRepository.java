package br.com.precisa.portalbiapi.repository.versao;

import br.com.precisa.portalbiapi.mapper.versao.VersaoRowMapper;
import br.com.precisa.portalbiapi.model.versao.Versao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class VersaoRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Versao findGraficoProjecaoRecebimentos() {

        Versao versao;

        String sql = " SELECT FIRST 1 PBI_FINGRAPRO1.VERSAO AS VERSAO_TRANSMISSAO, " +
                                    "  PBI_FINGRAPRO1.DATA AS DATA_TRANSMISSAO, " +
                                    "  PBI_FINGRAPRO1.HORA AS HORA_TRANSMISSAO " +
                     " FROM PBI_FINGRAPRO1 " +
                     " ORDER BY PBI_FINGRAPRO1.VERSAO DESCENDING ";

        Map<String, Object> params = new HashMap<>();

        versao = namedParameterJdbcTemplate.queryForObject(sql, params, new VersaoRowMapper());

        return versao;
    }
}
