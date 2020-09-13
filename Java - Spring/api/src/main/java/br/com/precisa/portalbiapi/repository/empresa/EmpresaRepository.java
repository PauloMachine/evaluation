package br.com.precisa.portalbiapi.repository.empresa;

import br.com.precisa.portalbiapi.mapper.empresa.EmpresaRowMapper;
import br.com.precisa.portalbiapi.model.empresa.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EmpresaRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Empresa> findById(String cnpj) {

        String sql = " SELECT TBLCDSEMP0.IDEMPRESA" +
                " FROM TBLCDSEMP0 " +
                " WHERE TBLCDSEMP0.CNPJ IN (" + cnpj + ")" +
                " AND TBLCDSEMP0.INATIVA = 0 " +
                " AND TBLCDSEMP0.BLOQUEAR = 0 " +
                " ORDER BY TBLCDSEMP0.IDEMPRESA ";

        List<Empresa> empresa;
        Map<String, Object> params = new HashMap<>();

        empresa = namedParameterJdbcTemplate.query(sql, params, new EmpresaRowMapper());

        return empresa;
    }
}
