package br.com.precisa.portalbiapi.repository.dashboard.vendas.rankingvendedores;

import br.com.precisa.portalbiapi.mapper.dashboard.vendas.rankingVendedores.RankingVendedoresRowMapper;
import br.com.precisa.portalbiapi.model.dashboard.vendas.rankingVendedores.RankingVendedores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RankingVendedoresRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<RankingVendedores> find(String idEmpresa, String ordenacao, String dataInicial, String dataFinal,
            Long iPage, Long iSize) {

        List<RankingVendedores> rankingVendedores;

        String sql = " SELECT FIRST " + iSize + " SKIP " + ((iPage - 1) * iSize) + " TBLCDSVEN0.VENDEDOR, "
                + " COUNT( DISTINCT TBLMVMFAT0.IDFATENT ) QUANTIDADE, " + " SUM( TBLMVMFAT0.VLRTOTAL ) FATURAMENTO, "
                + " SUM( TBLMVMFAT0.SOMACUSTO ) CUSTO, " + " SUM( TBLMVMFAT0.VLRTOTAL - TBLMVMFAT0.SOMACUSTO ) LUCRO "
                + " FROM TBLMVMFAT0 " + " LEFT JOIN TBLMVMFAT4 ON TBLMVMFAT4.IDFATENT = TBLMVMFAT0.IDFATENT "
                + " LEFT JOIN TBLCDSCOI0 ON TBLMVMFAT0.IDCOI = TBLCDSCOI0.IDCOI "
                + " LEFT JOIN TBLCDSVEN0 ON TBLCDSVEN0.IDVENDEDOR = TBLMVMFAT4.IDVENDEDOR "
                + " WHERE TBLCDSCOI0.VENDANORMAL = 1 AND " + "       TBLMVMFAT0.ENTSAI = 'S' AND "
                + "       TBLMVMFAT0.CANCELADA = 0 AND " + "       TBLMVMFAT0.DTEMISSAO BETWEEN '"
                + LocalDate.parse(dataInicial, DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "' AND " + "       '"
                + LocalDate.parse(dataFinal, DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "' AND "
                + "       TBLMVMFAT0.IDEMPRESA IN (" + idEmpresa + ")" + " GROUP BY 1 " + " ORDER BY " + ordenacao
                + " DESC ";

        Map<String, Object> params = new HashMap<>();

        rankingVendedores = namedParameterJdbcTemplate.query(sql, params, new RankingVendedoresRowMapper());

        return rankingVendedores;
    }

    public int countAll(String idEmpresa, String dataInicial, String dataFinal) {

        Integer totalRegistros;

        Map<String, Object> params = new HashMap<>();

        String sql = " SELECT COUNT(DISTINCT TBLCDSVEN0.vendedor) " + " FROM TBLMVMFAT0 "
                + " LEFT JOIN TBLMVMFAT4 ON TBLMVMFAT4.idfatent = TBLmvmfat0.idfatent "
                + " LEFT JOIN TBLCDSCOI0 ON TBLMVMFAT0.idcoi = TBLCDSCOI0.IDCOI "
                + " LEFT JOIN TBLCDSVEN0 ON TBLCDSVEN0.idvendedor = TBLMVMFAT4.idvendedor "
                + " WHERE TBLMVMFAT0.ENTSAI = 'S' AND " + "       TBLCDSCOI0.VENDANORMAL = 1 AND "
                + "       TBLMVMFAT0.CANCELADA = 0 AND " + "       TBLMVMFAT0.DTEMISSAO BETWEEN '"
                + LocalDate.parse(dataInicial, DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "' AND " + "       '"
                + LocalDate.parse(dataFinal, DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "' AND "
                + "       TBLMVMFAT0.IDEMPRESA IN (" + idEmpresa + ")";

        totalRegistros = namedParameterJdbcTemplate.queryForObject(sql, params, Integer.class);

        return totalRegistros;
    }

}
