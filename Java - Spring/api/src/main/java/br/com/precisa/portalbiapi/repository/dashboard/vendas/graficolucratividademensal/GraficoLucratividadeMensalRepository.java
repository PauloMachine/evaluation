package br.com.precisa.portalbiapi.repository.dashboard.vendas.graficolucratividademensal;

import br.com.precisa.portalbiapi.mapper.dashboard.vendas.graficolucratividademensal.GraficoLucratividadeMensalRowMapper;
import br.com.precisa.portalbiapi.model.dashboard.vendas.graficolucratividademensal.GraficoLucratividadeMensal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class GraficoLucratividadeMensalRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<GraficoLucratividadeMensal> findById(String idEmpresa, String dataInicial, String dataFinal) {

        List<GraficoLucratividadeMensal> graficoLucratividadeMensal;

        String sql = " SELECT EXTRACT(MONTH FROM TBLMVMFAT0.DTEMISSAO) MES, " +
                            " EXTRACT (YEAR FROM TBLMVMFAT0.DTEMISSAO ) ANO, " +
                            " SUM( TBLMVMFAT0.VLRTOTAL ) FATURAMENTO, " +
                            " SUM( TBLMVMFAT0.SOMACUSTO ) CUSTO, " +
                            " SUM( TBLMVMFAT0.VLRTOTAL - TBLMVMFAT0.SOMACUSTO ) LUCROBRUTO " +
                     " FROM TBLMVMFAT0 " +
                     " LEFT JOIN TBLCDSCOI0 ON TBLMVMFAT0.IDCOI = TBLCDSCOI0.IDCOI " +
                     " WHERE TBLMVMFAT0.ENTSAI = 'S' AND " +
                            " TBLCDSCOI0.VENDANORMAL = 1 AND " +
                            " TBLMVMFAT0.CANCELADA = 0 AND " +
                            " TBLMVMFAT0.DTEMISSAO BETWEEN '" + LocalDate.parse(dataInicial, DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "' AND " +
                            " '" + LocalDate.parse(dataFinal, DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "' AND " +
                            " TBLMVMFAT0.IDEMPRESA IN (" + idEmpresa + ")" +
                     " GROUP BY 1,2 " +
                     " ORDER BY 2,1 ";

        Map<String, Object> params = new HashMap<>();

        graficoLucratividadeMensal = namedParameterJdbcTemplate.query(sql, params, new GraficoLucratividadeMensalRowMapper());

        return graficoLucratividadeMensal;
    }
}
