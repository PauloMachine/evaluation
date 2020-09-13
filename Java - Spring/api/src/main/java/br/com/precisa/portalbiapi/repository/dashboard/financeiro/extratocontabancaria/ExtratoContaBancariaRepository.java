package br.com.precisa.portalbiapi.repository.dashboard.financeiro.extratocontabancaria;

import br.com.precisa.portalbiapi.mapper.dashboard.financeiro.extratocontabancaria.ExtratoContaBancariaRowMapper;
import br.com.precisa.portalbiapi.model.dashboard.financeiro.extratocontabancaria.ExtratoContaBancaria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ExtratoContaBancariaRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<ExtratoContaBancaria> findById(String idEmpresa, Long idConta, Long tipoLct, Long diasLct,
                                               String dataInicial, String dataFinal) {

        List<ExtratoContaBancaria> consultaDuplicataPagarDia;

        String sql = "SELECT R_TIPOTOTAL TIPOTOTAL, R_DATALANC DATALANC, R_HISTORICO HISTORICO, " +
                " R_COMPLEMENTO COMPLEMENTO, R_DEBITO DEBITO, R_CREDITO CREDITO, R_SALDO SALDO  " +
                " FROM PBI_EXTRATOCONTA('" + idEmpresa + "', " + idConta + ", " + tipoLct + ", " + diasLct +
                ", '" + LocalDate.parse(dataInicial, DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "', " +
                "'" + LocalDate.parse(dataFinal, DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "' ) ";

        Map<String, Object> params = new HashMap<>();

        consultaDuplicataPagarDia = namedParameterJdbcTemplate.query(sql, params, new ExtratoContaBancariaRowMapper());

        return consultaDuplicataPagarDia;
    }

}
