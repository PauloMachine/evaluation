package br.com.precisa.portalbiapi.config.security;

public class PrecisaEncoder implements org.springframework.security.crypto.password.PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence senhaDigitada, String senhaUsuario) {
        return senhaUsuario.toUpperCase().equals(senhaDigitada.toString().toUpperCase());
    }

}