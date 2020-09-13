package br.com.precisa.portalbiapi.repository.dashboard.financeiro.graficoprojecaorecebimentos;

import br.com.precisa.portalbiapi.mapper.dashboard.financeiro.graficoprojecaorecebimentos.GraficoProjecaoRecebimentosRowMapper;
import br.com.precisa.portalbiapi.model.dashboard.financeiro.graficoprojecaorecebimentos.GraficoProjecaoRecebimentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class GraficoProjecaoRecebimentosRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<GraficoProjecaoRecebimentos> findAll(String idEmpresa, String dataInicial, String dataFinal, Integer versao) {

        List<GraficoProjecaoRecebimentos> graficoProjecaoRecebimentos;

        String sql = "SELECT (SELECT FIRST 1 PBI_FINGRAPRO1.VERSAO" +
                            " FROM PBI_FINGRAPRO1" +
                            " ORDER BY PBI_FINGRAPRO1.VERSAO descending) VERSAO_TRANSMISSAO, " +
                            "(SELECT FIRST 1 PBI_FINGRAPRO1.DATA " +
                            " FROM PBI_FINGRAPRO1" +
                            " ORDER BY PBI_FINGRAPRO1.VERSAO descending) DATA_TRANSMISSAO," +
                            "(SELECT FIRST 1 PBI_FINGRAPRO1.HORA" +
                            " FROM PBI_FINGRAPRO1" +
                            " ORDER BY PBI_FINGRAPRO1.VERSAO descending) HORA_TRANSMISSAO," +
                            " PBI_FINGRAPRO0.DATA, " +
                            " SUM(PBI_FINGRAPRO0.dup_receber_dia) AS dup_receber_dia, " +
                            " SUM(PBI_FINGRAPRO0.dup_receber_dia_clientes_bons) AS dup_receber_dia_clientes_bons, " +
                            " SUM(PBI_FINGRAPRO0.dup_vlrecebido_dia) AS dup_vlrecebido_dia, " +
                            " SUM(PBI_FINGRAPRO0.dup_pagar_dia) AS dup_pagar_dia, " +
                            " SUM(PBI_FINGRAPRO0.che_pagar_dia) AS che_pagar_dia " +
                    " FROM PBI_FINGRAPRO0 " +
                    " WHERE PBI_FINGRAPRO0.VERSAO = " + versao + " AND " +
                          " PBI_FINGRAPRO0.IDEMPRESA IN ( " + idEmpresa + ") AND " +
                          " PBI_FINGRAPRO0.DATA BETWEEN '"+ LocalDate.parse(dataInicial, DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "' AND " +
                          "'" + LocalDate.parse(dataFinal, DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "'" +
                    " GROUP BY PBI_FINGRAPRO0.DATA ";

        Map<String, Object> params = new HashMap<>();

        graficoProjecaoRecebimentos = namedParameterJdbcTemplate.query(sql, params, new GraficoProjecaoRecebimentosRowMapper());

        return graficoProjecaoRecebimentos;
    }

    public void rechargeAll(String meioCob, Integer numeroDup, Integer diasMaxAtraso, String dataInicial, String dataFinal) {

        SqlParameterSource namedParameters = null;

        String sql = " EXECUTE PROCEDURE PBI_GERAFIN_GRAPRO0('" + meioCob + "', " + numeroDup + ", " + diasMaxAtraso + ", " +
                     "'" + LocalDate.parse(dataInicial, DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                     "', '" + LocalDate.parse(dataFinal, DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "' )";

        try {
            namedParameterJdbcTemplate.queryForObject(sql, namedParameters, Void.class);
        } catch (BadSqlGrammarException e) {}

    }

    public int findVersion() {

        Integer versao;

        SqlParameterSource namedParameters = null;

        String sql = " SELECT FIRST 1 PBI_FINGRAPRO0.VERSAO " +
                     " FROM PBI_FINGRAPRO0 " +
                     " ORDER BY PBI_FINGRAPRO0.VERSAO DESCENDING ";

        try {
            versao = namedParameterJdbcTemplate.queryForObject(sql, namedParameters, Integer.class);
        } catch (EmptyResultDataAccessException e) {
            return 0;
        }

        return versao;
    }


}
