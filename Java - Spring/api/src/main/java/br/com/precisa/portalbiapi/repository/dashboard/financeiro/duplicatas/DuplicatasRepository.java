package br.com.precisa.portalbiapi.repository.dashboard.financeiro.duplicatas;

import br.com.precisa.portalbiapi.mapper.dashboard.financeiro.duplicatas.DuplicatasRowMapper;
import br.com.precisa.portalbiapi.model.dashboard.financeiro.duplicatas.Duplicatas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DuplicatasRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public long findAllCount(String idEmpresa, String dataInicial, String dataFinal) {

        Long totalRegistros;

        String sql = " SELECT COUNT(*) " +
                " FROM TBLMVMPAG0 LEFT JOIN TBLCDSCLI0 ON TBLMVMPAG0.IDCLIENTE = TBLCDSCLI0.IDCLIENTE " +
                " WHERE TBLMVMPAG0.PGTO IS NULL " +
                " AND TBLMVMPAG0.VCTO BETWEEN '" + LocalDate.parse(dataInicial, DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                "' AND '" + LocalDate.parse(dataFinal, DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "' " +
                " AND TBLMVMPAG0.IDEMPRESA IN (" + idEmpresa + ")";

        Map<String, Object> params = new HashMap<>();

        totalRegistros = namedParameterJdbcTemplate.queryForObject(sql, params, Long.class);

        return totalRegistros;
    }

    public double findAllSum(String idEmpresa, String dataInicial, String dataFinal) {

        Double totalRegistros;

        String sql = " SELECT SUM(TBLMVMPAG0.SALDO) " +
                " FROM TBLMVMPAG0 LEFT JOIN TBLCDSCLI0 ON TBLMVMPAG0.IDCLIENTE = TBLCDSCLI0.IDCLIENTE " +
                " WHERE TBLMVMPAG0.PGTO IS NULL " +
                " AND TBLMVMPAG0.VCTO BETWEEN '" + LocalDate.parse(dataInicial, DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                "' AND '" + LocalDate.parse(dataFinal, DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "' " +
                " AND TBLMVMPAG0.IDEMPRESA IN (" + idEmpresa + ")";

        Map<String, Object> params = new HashMap<>();

        totalRegistros = namedParameterJdbcTemplate.queryForObject(sql, params, Double.class);

        if (totalRegistros == null) {
            return 0;
        }

        return totalRegistros;
    }

    public List<Duplicatas> findById(String idEmpresa, Long page, Long size, String dataInicial, String dataFinal) {

        List<Duplicatas> duplicatas;

        String sql = " SELECT FIRST " + size + " SKIP " + ((page - 1) * size) +
                " TBLMVMPAG0.SALDO, TBLMVMPAG0.VALOR, TBLMVMPAG0.CREDITO, TBLMVMPAG0.NOTA, " +
                " TBLMVMPAG0.DUPL, TBLMVMPAG0.EMISSAO, TBLMVMPAG0.VCTO, TBLMVMPAG0.PARCELA, " +
                " TBLMVMPAG0.IDCLIENTE, TBLCDSCLI0.RAZAO " +
                " FROM TBLMVMPAG0 LEFT JOIN TBLCDSCLI0 ON TBLMVMPAG0.IDCLIENTE = TBLCDSCLI0.IDCLIENTE " +
                " WHERE TBLMVMPAG0.PGTO IS NULL " +
                " AND TBLMVMPAG0.VCTO BETWEEN '" + LocalDate.parse(dataInicial, DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                "' AND '" + LocalDate.parse(dataFinal, DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "' " +
                " AND TBLMVMPAG0.IDEMPRESA IN (" + idEmpresa + ")" +
                " ORDER BY TBLMVMPAG0.VCTO";

        Map<String, Object> params = new HashMap<>();

        duplicatas = namedParameterJdbcTemplate.query(sql, params, new DuplicatasRowMapper());

        return duplicatas;
    }
}
