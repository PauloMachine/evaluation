package br.com.precisa.portalbiapi.repository.dashboard.financeiro.saldocontabancaria;

import br.com.precisa.portalbiapi.mapper.dashboard.financeiro.saldocontabancaria.SaldoContaBancariaRowMapper;
import br.com.precisa.portalbiapi.model.dashboard.financeiro.saldocontabancaria.SaldoContaBancaria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SaldoContaBancariaRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<SaldoContaBancaria> findById(String idEmpresa, String dataInicial) {

        List<SaldoContaBancaria> saldoContaBancarias;

        String sql = " SELECT R_IDCONTA IDCONTA, R_NOMECONTA NOMECONTA, R_CLASSIFICACAO CLASSIFICACAO, " +
                " R_SALDO SALDO, R_COR COR, R_LIMITE LIMITE " +
                " FROM FIN_SALDO_LISTA_CTABAN( '" + idEmpresa + "' , '" + LocalDate.parse(dataInicial, DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "' ) " +
                " ORDER BY NOMECONTA ";

        Map<String, Object> params = new HashMap<>();

        saldoContaBancarias = namedParameterJdbcTemplate.query(sql, params, new SaldoContaBancariaRowMapper());

        return saldoContaBancarias;
    }
}
