package br.com.precisa.portalbiapi.config.security.repository.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class TokenRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void insertBackList(String token) {

        String sql = "INSERT INTO TBLTOKEN (TOKEN) VALUES (:TOKEN)";

        Map<String, Object> params = new HashMap<>();
        params.put("TOKEN", token);

        namedParameterJdbcTemplate.update(sql, params);
    }

    public String findInBlackList(String token) {

        String sToken;

        String sql = "SELECT FIRST 1 TBLTOKEN.TOKEN FROM TBLTOKEN WHERE TBLTOKEN.TOKEN = :TOKEN";

        Map<String, Object> params = new HashMap<>();
        params.put("TOKEN", token);

        try {
            sToken = namedParameterJdbcTemplate.queryForObject(sql, params, String.class);
        } catch (EmptyResultDataAccessException e) {
            sToken = null;
        }

        return sToken;
    }
}