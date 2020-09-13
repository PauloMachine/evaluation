package br.com.precisa.portalbiapi.repository.dashboard.vendas.rankingsecoes;

import br.com.precisa.portalbiapi.mapper.dashboard.vendas.rankingsecoes.RankingSecoesRowMapper;
import br.com.precisa.portalbiapi.model.dashboard.vendas.rankingsecoes.RankingSecoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RankingSecoesRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<RankingSecoes> find(String idEmpresa, String ordenacao, String dataInicial, String dataFinal, Long iPage, Long iSize) {

        List<RankingSecoes> secoes;

        String sql = " SELECT FIRST " + iSize + " SKIP " + ((iPage - 1) * iSize) +
                     "        TBLCDSSEC0.SECAO, " +
                     "        COUNT( DISTINCT TBLMVMITE0.IDCHAVEMVI ) QUANTIDADE, " +
                     "        SUM( TBLMVMITE0.VLRTOTAL ) FATURAMENTO, " +
                     "        SUM( TBLMVMITE0.CUSTO ) CUSTO, " +
                     "        SUM( TBLMVMITE0.VLRTOTAL - TBLMVMITE0.CUSTO ) LUCRO " +
                     " FROM TBLMVMITE0 " +
                     " LEFT JOIN TBLCDSCOI0 ON TBLMVMITE0.IDCOI = TBLCDSCOI0.IDCOI " +
                     " LEFT JOIN TBLCDSITE0 ON TBLMVMITE0.IDITEM = TBLCDSITE0.IDITEM " +
                     " LEFT JOIN TBLCDSSEC0 ON TBLCDSITE0.IDSECAO = TBLCDSSEC0.IDSECAO " +
                     " WHERE TBLCDSCOI0.VENDANORMAL = 1 AND " +
                     "       TBLCDSSEC0.IDGRUPO = 0 AND " +
                     "       TBLCDSSEC0.IDSUBGRUPO = 0 AND " +
                     "       TBLMVMITE0.IDEMPRESA IN (" + idEmpresa + ") AND" +
                     "       TBLMVMITE0.NATUREZA = 'S' AND " +
                     "       TBLMVMITE0.CANCEL = 0 AND " +
                     "       TBLMVMITE0.DTVALIDA BETWEEN '" + LocalDate.parse(dataInicial, DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "' AND " +
                     "       '" + LocalDate.parse(dataFinal, DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "' " +
                     " GROUP BY 1 " +
                     " ORDER BY " + ordenacao +" DESC ";

        Map<String, Object> params = new HashMap<>();

        secoes = namedParameterJdbcTemplate.query(sql, params, new RankingSecoesRowMapper());

        return secoes;
    }

    public int countAll(String idEmpresa, String dataInicial, String dataFinal) {

        Integer totalRegistros;

        Map<String, Object> params = new HashMap<>();

        String sql = " SELECT COUNT( DISTINCT TBLCDSSEC0.IDSECAO )" +
                     " FROM TBLMVMITE0 " +
                     " LEFT JOIN TBLCDSCOI0 ON TBLMVMITE0.IDCOI = TBLCDSCOI0.IDCOI " +
                     " LEFT JOIN TBLCDSITE0 ON TBLMVMITE0.IDITEM = TBLCDSITE0.IDITEM " +
                     " LEFT JOIN TBLCDSSEC0 ON TBLCDSITE0.IDSECAO = TBLCDSSEC0.IDSECAO " +
                     " WHERE TBLCDSCOI0.VENDANORMAL = 1 AND " +
                     "       TBLCDSSEC0.IDGRUPO = 0 AND " +
                     "       TBLCDSSEC0.IDSUBGRUPO = 0 AND " +
                     "       TBLMVMITE0.IDEMPRESA IN (" + idEmpresa + ") AND" +
                     "       TBLMVMITE0.NATUREZA = 'S' AND " +
                     "       TBLMVMITE0.CANCEL = 0 AND " +
                     "       TBLMVMITE0.DTVALIDA BETWEEN '" + LocalDate.parse(dataInicial, DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "' AND " +
                     "       '" + LocalDate.parse(dataFinal, DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "' ";

        totalRegistros = namedParameterJdbcTemplate.queryForObject(sql, params, Integer.class);

        return totalRegistros;
    }
}
