package br.com.precisa.portalbiapi.repository.dashboard.vendas.produtosnaovendidos;

import br.com.precisa.portalbiapi.mapper.dashboard.vendas.produtosnaovendidos.ProdutosNaoVendidosRowMapper;
import br.com.precisa.portalbiapi.model.dashboard.vendas.produtosnaovendidos.ProdutosNaoVendidos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProdutosNaoVendidosRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<ProdutosNaoVendidos> findById(String idEmpresa, Integer periodo, String ordenacao, Long iPage,
            Long iSize) {

        List<ProdutosNaoVendidos> produtosNaoVendidos;

        String sql = " SELECT FIRST " + iSize + " SKIP " + ((iPage - 1) * iSize)
                + " TBLCDSITE0.IDITEM, TBLCDSITE0.UNDVEND1, " + " TBLCDSITE0.NOMEPRO, " + " TBLCDSITE0.DTCAD, "
                + " TBLCDSITE1.ULTVENDA, " + " SUM(TBLSDOITE1.SALDO) AS SALDO" + " FROM TBLCDSITE0 "
                + " LEFT JOIN TBLCDSITE1 ON TBLCDSITE0.IDITEM = TBLCDSITE1.IDITEM "
                + " LEFT JOIN TBLSDOITE1 ON TBLCDSITE0.IDITEM = TBLSDOITE1.IDITEM "
                + " WHERE TBLCDSITE0.STATUS = 'A' AND " + " (CURRENT_DATE - TBLCDSITE0.DTCAD) >= " + periodo + " AND "
                + " (CURRENT_DATE - TBLCDSITE1.ULTVENDA) >= " + periodo + " AND " + " TBLSDOITE1.IDEMPRESA IN ("
                + idEmpresa + ") AND " + " TBLSDOITE1.SALDO > 0 " + " GROUP BY 1,2,3,4,5 ORDER BY " + ordenacao
                + " DESC ";

        Map<String, Object> params = new HashMap<>();

        produtosNaoVendidos = namedParameterJdbcTemplate.query(sql, params, new ProdutosNaoVendidosRowMapper());

        return produtosNaoVendidos;
    }

    public int countAll(String idEmpresa, Integer periodo) {

        Integer totalRegistros;

        Map<String, Object> params = new HashMap<>();

        String sql = " SELECT COUNT(DISTINCT TBLCDSITE0.IDITEM) " + " FROM TBLCDSITE0 "
                + " LEFT JOIN TBLCDSITE1 ON TBLCDSITE0.IDITEM = TBLCDSITE1.IDITEM "
                + " LEFT JOIN TBLSDOITE1 ON TBLCDSITE0.IDITEM = TBLSDOITE1.IDITEM "
                + " WHERE TBLCDSITE0.STATUS = 'A' AND " + " (CURRENT_DATE - TBLCDSITE0.DTCAD) >= " + periodo + " AND "
                + " (CURRENT_DATE - TBLCDSITE1.ULTVENDA) >= " + periodo + " AND " + " TBLSDOITE1.IDEMPRESA IN  ("
                + idEmpresa + ") AND " + " TBLSDOITE1.SALDO > 0 ";

        totalRegistros = namedParameterJdbcTemplate.queryForObject(sql, params, Integer.class);

        return totalRegistros;
    }

}
