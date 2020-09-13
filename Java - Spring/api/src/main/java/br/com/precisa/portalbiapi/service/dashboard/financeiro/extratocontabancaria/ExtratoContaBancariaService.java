package br.com.precisa.portalbiapi.service.dashboard.financeiro.extratocontabancaria;

import br.com.precisa.portalbiapi.model.dashboard.financeiro.extratocontabancaria.ExtratoContaBancaria;
import br.com.precisa.portalbiapi.repository.dashboard.financeiro.extratocontabancaria.ExtratoContaBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExtratoContaBancariaService {

    @Autowired
    private ExtratoContaBancariaRepository extratoContaBancariaRepository;

    public List<ExtratoContaBancaria> findById(String idEmpresa, Long idConta, Long tipoLct, Long diasLct,
                                               String dataInicial) {

        // A data final é referenciada pela data inicial que vem do saldo bancário
        String dataFinal = dataInicial;

        return extratoContaBancariaRepository.findById(idEmpresa, idConta, tipoLct, diasLct, dataInicial, dataFinal);
    }

}

