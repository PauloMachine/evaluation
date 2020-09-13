package br.com.precisa.portalbiapi.repository.usuario;

import br.com.precisa.portalbiapi.mapper.usuario.UsuarioRowMapper;
import br.com.precisa.portalbiapi.model.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UsuarioRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Usuario findByLogin(String login) {

        Usuario usuario;

        String sql = " SELECT TBLCDSUSR0.IDUSUARIO, TBLCDSUSR0.LOGIN, TBLCDSUSR0.SENHA, TBLCDSUSR0.NOME\n" +
                " FROM TBLCDSUSR0\n" +
                " WHERE TBLCDSUSR0.LOGIN = :LOGIN ";

        Map<String, Object> params = new HashMap<>();
        params.put("LOGIN", login);

        usuario = namedParameterJdbcTemplate.queryForObject(sql, params, new UsuarioRowMapper());

        return usuario;
    }

}
