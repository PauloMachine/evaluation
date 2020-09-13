package br.com.precisa.portalbiapi.repository.contaspagar;

import br.com.precisa.portalbiapi.mapper.contaspagar.ContasPagarRowMapper;
import br.com.precisa.portalbiapi.model.contaspagar.ContasPagar;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ContasPagarRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<ContasPagar> findAll() {

        List<ContasPagar> contasPagar;

        String sql = " SELECT PBI_TBLCDSPAG0.IDPAG, PBI_TBLCDSPAG0.COR, PBI_TBLCDSPAG0.DTVCTO, "
                + " PBI_TBLCDSPAG0.RAZAO, PBI_TBLCDSPAG0.VALOR, PBI_TBLCDSPAG0.STSPGTO, "
                + " PBI_TBLCDSPAG0.NUMERO, PBI_TBLCDSPAG0.OBSERVACAO, PBI_TBLCDSBAN0.NOMEREDUZ, "
                + " PBI_TBLCDSPAG0.IDCONTA, PBI_TBLCDSBAN0.COR AS CORCONTA " + " FROM PBI_TBLCDSPAG0 "
                + " JOIN PBI_TBLCDSBAN0 ON (PBI_TBLCDSBAN0.IDCONTA = PBI_TBLCDSPAG0.IDCONTA) "
                + " ORDER BY PBI_TBLCDSPAG0.DTVCTO DESC ";

        Map<String, Object> params = new HashMap<>();

        contasPagar = namedParameterJdbcTemplate.query(sql, params, new ContasPagarRowMapper());

        return contasPagar;
    }

    public int findAllCount() {

        Integer totalRegistros;

        SqlParameterSource namedParameters = null;

        String sql = " SELECT COUNT(PBI_TBLCDSPAG0.IDPAG) FROM PBI_TBLCDSPAG0";

        totalRegistros = namedParameterJdbcTemplate.queryForObject(sql, namedParameters, Integer.class);

        return totalRegistros;
    }

    public int InsertOrUpdate(ContasPagar contasPagar) {

        String sql = " UPDATE OR INSERT INTO PBI_TBLCDSPAG0 ( IDPAG, IDCONTA, VALOR, NUMERO, "
                + " STSPGTO, COR, DTVCTO, RAZAO, OBSERVACAO ) "
                + " VALUES (:IDPAG, :IDCONTA, :VALOR, :NUMERO, :STSPGTO, :COR, :DTVCTO, :RAZAO, :OBSERVACAO )";

        Map<String, Object> params = new HashMap<>();
        params.put("IDPAG", contasPagar.getIdPag());
        params.put("IDCONTA", contasPagar.getIdConta());
        params.put("VALOR", contasPagar.getValor());
        params.put("NUMERO", contasPagar.getNumero());
        params.put("STSPGTO", contasPagar.getStsPgto());
        params.put("COR", contasPagar.getCor());
        params.put("DTVCTO", LocalDate.parse(contasPagar.getDtVcto(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        params.put("RAZAO", contasPagar.getRazao());
        params.put("OBSERVACAO", contasPagar.getObservacao());

        try {
            namedParameterJdbcTemplate.update(sql, params);
            return 0;
        } catch (DateTimeParseException e) {
            return 1;
        }
    }

    public void updateById(Long idPag) {
        String sql = " UPDATE PBI_TBLCDSPAG0 " + " SET STSPGTO = 1 " + " WHERE PBI_TBLCDSPAG0.IDPAG = " + idPag;

        Map<String, Object> params = new HashMap<>();

        namedParameterJdbcTemplate.update(sql, params);
    }

    public ContasPagar findById(Long idPag) {

        ContasPagar contasPagar;

        String sql = " SELECT PBI_TBLCDSPAG0.IDPAG, PBI_TBLCDSPAG0.COR, PBI_TBLCDSPAG0.DTVCTO, "
                + " PBI_TBLCDSPAG0.RAZAO, PBI_TBLCDSPAG0.VALOR, PBI_TBLCDSPAG0.STSPGTO, "
                + " PBI_TBLCDSPAG0.NUMERO, PBI_TBLCDSPAG0.OBSERVACAO, PBI_TBLCDSBAN0.NOMEREDUZ, "
                + " PBI_TBLCDSBAN0.IDCONTA, PBI_TBLCDSBAN0.NOMEREDUZ AS NOMEREDUZCONTA, PBI_TBLCDSBAN0.COR AS CORCONTA "
                + " FROM PBI_TBLCDSPAG0 " + " JOIN PBI_TBLCDSBAN0 ON (PBI_TBLCDSBAN0.IDCONTA = PBI_TBLCDSPAG0.IDCONTA) "
                + " WHERE PBI_TBLCDSPAG0.IDPAG = " + idPag;

        Map<String, Object> params = new HashMap<>();

        contasPagar = namedParameterJdbcTemplate.queryForObject(sql, params, new ContasPagarRowMapper());

        return contasPagar;
    }

    public boolean deleteById(Long idConta) {
        String sql = "DELETE FROM PBI_TBLCDSPAG0 WHERE PBI_TBLCDSPAG0.IDPAG = " + idConta;

        Map<String, Object> params = new HashMap<>();

        int update = namedParameterJdbcTemplate.update(sql, params);

        return update > 0;
    }
}
