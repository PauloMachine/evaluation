package br.com.precisa.portalbiapi.service.configuracao;

import br.com.precisa.portalbiapi.model.configuracao.Configuracao;
import br.com.precisa.portalbiapi.repository.configuracao.ConfiguracaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfiguracaoService {

    @Autowired
    private ConfiguracaoRepository configuracaoRepository;

    public Configuracao findAll() {
        return configuracaoRepository.findAll();
    }

    public void InsertOrUpdate(Configuracao configuracao) {
        configuracaoRepository.InsertOrUpdate(configuracao);
    }
}
