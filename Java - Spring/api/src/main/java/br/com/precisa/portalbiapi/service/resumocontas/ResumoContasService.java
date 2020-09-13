package br.com.precisa.portalbiapi.service.resumocontas;

import br.com.precisa.portalbiapi.model.resumocontas.ResumoContas;
import br.com.precisa.portalbiapi.repository.resumocontas.ResumoContasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumoContasService {

    @Autowired
    private ResumoContasRepository resumoContasRepository;

    public List<ResumoContas> findAll(String dataInicial, String dataFinal) {
        return resumoContasRepository.findAll(dataInicial, dataFinal);
    }

}
