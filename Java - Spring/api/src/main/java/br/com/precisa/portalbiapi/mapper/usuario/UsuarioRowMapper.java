package br.com.precisa.portalbiapi.mapper.usuario;

import br.com.precisa.portalbiapi.model.usuario.Usuario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioRowMapper implements RowMapper<Usuario> {

    @Override
    public Usuario mapRow(ResultSet resultSet, int i) throws SQLException {

        Usuario usuario = new Usuario();

        usuario.setIdUsuario(resultSet.getLong("IDUSUARIO"));
        usuario.setLogin(resultSet.getString("LOGIN"));
        usuario.setPassword(resultSet.getString("SENHA"));
        usuario.setNome(resultSet.getString("NOME"));

        return usuario;
    }
}
