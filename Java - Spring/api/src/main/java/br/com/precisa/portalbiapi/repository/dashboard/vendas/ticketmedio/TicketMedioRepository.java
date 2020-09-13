package br.com.precisa.portalbiapi.repository.dashboard.vendas.ticketmedio;

import br.com.precisa.portalbiapi.mapper.dashboard.vendas.ticketmedio.TicketMedioRowMapper;
import br.com.precisa.portalbiapi.model.dashboard.vendas.ticketmedio.TicketMedio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TicketMedioRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<TicketMedio> find(String idEmpresa, String dataInicial, String dataFinal) {

        List<TicketMedio> vendas;

        String sql = " SELECT COUNT( TBLMVMFAT0.IDFATENT ) TOTALVENDAS, " + " SUM( TBLMVMFAT0.VLRTOTAL ) FATURAMENTO, "
                + " ( SELECT SUM( TBLMVMITE0.QTDE ) " + "   FROM TBLMVMFAT0"
                + "   LEFT JOIN TBLCDSCOI0 ON TBLMVMFAT0.IDCOI = TBLCDSCOI0.IDCOI"
                + "   LEFT JOIN TBLMVMITE0 ON TBLMVMITE0.IDFATENT = TBLMVMFAT0.IDFATENT"
                + "   WHERE TBLCDSCOI0.VENDANORMAL = 1 AND " + "         TBLMVMFAT0.ENTSAI = 'S' AND "
                + "         TBLMVMFAT0.CANCELADA = 0 AND " + "         TBLMVMFAT0.DTEMISSAO BETWEEN '"
                + LocalDate.parse(dataInicial, DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "' AND " + " '"
                + LocalDate.parse(dataFinal, DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "' AND "
                + "         TBLMVMFAT0.IDEMPRESA IN (" + idEmpresa + ")" + " ) QTDVENDIDA, "
                + " ( SELECT COUNT( DISTINCT TBLMVMITE0.IDFATENT ) " + "        FROM TBLMVMITE0 "
                + "        LEFT JOIN TBLCDSCOI0 ON TBLMVMITE0.IDCOI = TBLCDSCOI0.IDCOI "
                + "        WHERE TBLCDSCOI0.VENDANORMAL = 1 AND " + "              TBLMVMITE0.IDEMPRESA IN ("
                + idEmpresa + ") AND " + "              TBLMVMITE0.NATUREZA = 'S' AND "
                + "              TBLMVMITE0.CANCEL = 0 AND " + "              TBLMVMITE0.DTVALIDA BETWEEN '"
                + LocalDate.parse(dataInicial, DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "' AND " + " '"
                + LocalDate.parse(dataFinal, DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "' AND "
                + "              TBLMVMITE0.IDFATENT IS NOT NULL ) QTDPRODUTO, "
                + "        ( SELECT COUNT (TBLMVMITE0.IDCHAVEMVI ) "
                + "        FROM TBLMVMITE0 LEFT JOIN TBLCDSCOI0 ON TBLMVMITE0.IDCOI = TBLCDSCOI0.IDCOI "
                + "        WHERE TBLCDSCOI0.VENDANORMAL = 1 AND " + "              TBLMVMITE0.IDEMPRESA IN ("
                + idEmpresa + ") AND " + "              TBLMVMITE0.NATUREZA = 'S' AND "
                + "              TBLMVMITE0.CANCEL = 0 AND " + "              TBLMVMITE0.DTVALIDA BETWEEN '"
                + LocalDate.parse(dataInicial, DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "' AND " + " '"
                + LocalDate.parse(dataFinal, DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "' AND "
                + "              TBLMVMITE0.IDFATENT IS NOT NULL ) QTDPRODUTOVEN " + " FROM TBLMVMFAT0 "
                + " LEFT JOIN TBLCDSCOI0 ON TBLMVMFAT0.IDCOI = TBLCDSCOI0.IDCOI "
                + " WHERE TBLMVMFAT0.ENTSAI = 'S' AND " + " TBLCDSCOI0.VENDANORMAL = 1 AND "
                + " TBLMVMFAT0.CANCELADA = 0 AND " + " TBLMVMFAT0.DTEMISSAO BETWEEN '"
                + LocalDate.parse(dataInicial, DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "' AND " + " '"
                + LocalDate.parse(dataFinal, DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "' AND "
                + " TBLMVMFAT0.IDEMPRESA IN (" + idEmpresa + ")";

        Map<String, Object> params = new HashMap<>();

        vendas = namedParameterJdbcTemplate.query(sql, params, new TicketMedioRowMapper());

        return vendas;
    }

}
