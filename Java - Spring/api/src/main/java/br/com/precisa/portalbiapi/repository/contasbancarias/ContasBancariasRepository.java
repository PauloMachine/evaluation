package br.com.precisa.portalbiapi.repository.contasbancarias;

import br.com.precisa.portalbiapi.mapper.contasbancarias.ContasBancariasRowMapper;
import br.com.precisa.portalbiapi.model.contasbancarias.ContasBancarias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ContasBancariasRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<ContasBancarias> findAll(Integer limiteCtb) {

        List<ContasBancarias> contasBancarias;

        String sql = " SELECT  FIRST " + limiteCtb + "" +
                " PBI_TBLCDSBAN0.IDCONTA, TBLCDSCTB0.IDCONTACTB, PBI_TBLCDSBAN0.AGENCIA, PBI_TBLCDSBAN0.CONTA, " +
                " PBI_TBLCDSBAN0.COR, PBI_TBLCDSBAN0.NOMEREDUZ, PBI_TBLCDSBAN0.LIMITE, TBLCDSCTB0.NOMECONTA, " +
                " PBI_TBLCDSBAN0.STSSALDOACU, PBI_TBLCDSBAN0.STSSALDOIND " +
                " FROM PBI_TBLCDSBAN0 " +
                " LEFT JOIN TBLCDSCTB0 ON (TBLCDSCTB0.IDCONTACTB = PBI_TBLCDSBAN0.IDCONTACTB) " +
                " ORDER BY PBI_TBLCDSBAN0.IDCONTA ";

        Map<String, Object> params = new HashMap<>();

        contasBancarias = namedParameterJdbcTemplate.query(sql, params, new ContasBancariasRowMapper());

        return contasBancarias;
    }

    public int findAllCount() {
        SqlParameterSource namedParameters = null;

        String sql = " SELECT COUNT(PBI_TBLCDSBAN0.IDCONTA) FROM PBI_TBLCDSBAN0 ";

        try {
            Integer totalRegistros;

            totalRegistros = namedParameterJdbcTemplate.queryForObject(sql, namedParameters, Integer.class);

            return totalRegistros;
        } catch (Exception e) {
            return 0;
        }
    }

    public ContasBancarias findById(Integer idConta) {

        ContasBancarias contasBancarias;

        String sql = " SELECT PBI_TBLCDSBAN0.IDCONTA, TBLCDSCTB0.IDCONTACTB, " +
                        " PBI_TBLCDSBAN0.AGENCIA, PBI_TBLCDSBAN0.CONTA, " +
                        " PBI_TBLCDSBAN0.COR, PBI_TBLCDSBAN0.NOMEREDUZ, PBI_TBLCDSBAN0.LIMITE, TBLCDSCTB0.NOMECONTA, " +
                        " PBI_TBLCDSBAN0.STSSALDOACU, PBI_TBLCDSBAN0.STSSALDOIND " +
                     " FROM PBI_TBLCDSBAN0 " +
                     " LEFT JOIN TBLCDSCTB0 ON (TBLCDSCTB0.IDCONTACTB = PBI_TBLCDSBAN0.IDCONTACTB) " +
                     " WHERE PBI_TBLCDSBAN0.IDCONTA = " + idConta;

        Map<String, Object> params = new HashMap<>();

        contasBancarias = namedParameterJdbcTemplate.queryForObject(sql, params, new ContasBancariasRowMapper());

        return contasBancarias;
    }

    public void InsertOrUpdate(ContasBancarias contasBancarias) {

        String sql = " UPDATE OR INSERT INTO PBI_TBLCDSBAN0 ( IDCONTA, IDCONTACTB, AGENCIA, CONTA, " +
                " COR, NOMEREDUZ, LIMITE, STSSALDOACU, STSSALDOIND ) " +
                " VALUES (:IDCONTA, :IDCONTACTB, :AGENCIA, :CONTA, :COR, :NOMEREDUZ, :LIMITE, :STSSALDOACU, :STSSALDOIND )";

        Map<String, Object> params = new HashMap<>();
        params.put("IDCONTA", contasBancarias.getIdConta());
        params.put("IDCONTACTB", contasBancarias.getIdContaCtb());
        params.put("AGENCIA", contasBancarias.getAgencia());
        params.put("CONTA", contasBancarias.getConta());
        params.put("COR", contasBancarias.getCor());
        params.put("NOMEREDUZ", contasBancarias.getNome().toUpperCase());
        params.put("LIMITE", contasBancarias.getLimite());
        params.put("STSSALDOACU", contasBancarias.getStsSaldoAcu());
        params.put("STSSALDOIND", contasBancarias.getStsSaldoInd());

        namedParameterJdbcTemplate.update(sql, params);
    }

    public boolean deleteById(Long idConta) {
        String sql = " DELETE FROM PBI_TBLCDSBAN0 WHERE PBI_TBLCDSBAN0.IDCONTA = " + idConta;

        Map<String, Object> params = new HashMap<>();

        int update = namedParameterJdbcTemplate.update(sql, params);

        return update > 0;
    }
}
