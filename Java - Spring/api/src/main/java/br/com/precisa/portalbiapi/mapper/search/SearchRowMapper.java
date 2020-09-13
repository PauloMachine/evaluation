package br.com.precisa.portalbiapi.mapper.search;

import br.com.precisa.portalbiapi.model.search.Search;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchRowMapper implements RowMapper<Search> {

    @Override
    public Search mapRow(ResultSet resultSet, int i) throws SQLException {

        Search search = new Search();

        search.setId(resultSet.getLong("ID"));
        search.setNome(resultSet.getString("NOME"));

        return search;
    }
}

