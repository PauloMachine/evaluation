package br.com.precisa.portalbiapi.service.versao;

import br.com.precisa.portalbiapi.model.versao.Versao;
import br.com.precisa.portalbiapi.repository.versao.VersaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VersaoService {

    @Autowired
    private VersaoRepository versaoRepository;

    public Versao findGraficoProjecaoRecebimentos() {
        return versaoRepository.findGraficoProjecaoRecebimentos();
    }
}
