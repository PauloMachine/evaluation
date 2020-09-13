package br.com.precisa.portalbiapi.mapper.empresa;

import br.com.precisa.portalbiapi.model.empresa.Empresa;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpresaRowMapper implements RowMapper<Empresa> {

    @Override
    public Empresa mapRow(ResultSet resultSet, int i) throws SQLException {

        Empresa empresa = new Empresa();

        empresa.setIdEmpresa(resultSet.getInt("IDEMPRESA"));

        return empresa;
    }

}
