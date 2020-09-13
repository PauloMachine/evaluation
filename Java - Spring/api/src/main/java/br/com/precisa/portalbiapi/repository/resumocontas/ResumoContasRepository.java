package br.com.precisa.portalbiapi.repository.resumocontas;

import br.com.precisa.portalbiapi.mapper.resumocontas.ResumoContasRowMapper;
import br.com.precisa.portalbiapi.model.resumocontas.ResumoContas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ResumoContasRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<ResumoContas> findAll(String dataInicial, String dataFinal) {

        List<ResumoContas> resumoContas;

        String sql = " SELECT * FROM PBI_CONTASPAGARDIA ('" + LocalDate.parse(dataInicial, DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "', '" + LocalDate.parse(dataFinal, DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "' ) ";

        Map<String, Object> params = new HashMap<>();

        resumoContas = namedParameterJdbcTemplate.query(sql, params, new ResumoContasRowMapper());

        return resumoContas;
    }

}
