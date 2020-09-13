package br.com.precisa.portalbiapi.repository.search;

import br.com.precisa.portalbiapi.mapper.search.SearchRowMapper;
import br.com.precisa.portalbiapi.model.search.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SearchRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Search> findByContaBancariaPBI() {

        List<Search> searchContaBancaria;

        String sql = " SELECT PBI_TBLCDSBAN0.IDCONTA AS ID, PBI_TBLCDSBAN0.NOMEREDUZ AS NOME " +
                     " FROM PBI_TBLCDSBAN0 " +
                     " ORDER BY PBI_TBLCDSBAN0.NOMEREDUZ";

        Map<String, Object> params = new HashMap<>();

        searchContaBancaria = namedParameterJdbcTemplate.query(sql, params, new SearchRowMapper());

        return searchContaBancaria;
    }

    public List<Search> findByContaBancariaSolution() {

        List<Search> searchContaBancaria;

        String sql = " SELECT TBLCDSCTB0.IDCONTACTB AS ID, TBLCDSCTB0.NOMECONTA AS NOME " +
                     " FROM TBLCDSCTB0 " +
                     " ORDER BY TBLCDSCTB0.NOMECONTA ";

        Map<String, Object> params = new HashMap<>();

        searchContaBancaria =  namedParameterJdbcTemplate.query(sql, params, new SearchRowMapper());

        return searchContaBancaria;
    }

    public List<Search> findByEmpresa(String search) {

        List<Search> searchContaBancaria;

        String sql = " SELECT FIRST 10 TBLCDSEMP0.IDEMPRESA AS ID, TBLCDSEMP0.RAZAOSOCIAL AS NOME " +
                " FROM TBLCDSEMP0 " +
                " WHERE TBLCDSEMP0.RAZAOSOCIAL LIKE UPPER(:SEARCH) " +
                " AND TBLCDSEMP0.INATIVA = 0";

        Map<String, Object> params = new HashMap<>();
        String likeSearch = '%'+search+'%';
        params.put("SEARCH", likeSearch);

        searchContaBancaria =  namedParameterJdbcTemplate.query(sql, params, new SearchRowMapper());

        return searchContaBancaria;
    }

    public List<Search> findAll() {

        List<Search> searchContaBancaria;

        String sql = " SELECT TBLCDSEMP0.IDEMPRESA AS ID, TBLCDSEMP0.RAZAOSOCIAL AS NOME " +
                " FROM TBLCDSEMP0 " +
                " WHERE TBLCDSEMP0.INATIVA = 0";

        searchContaBancaria = namedParameterJdbcTemplate.query(sql, new SearchRowMapper());

        return searchContaBancaria;
    }
}
