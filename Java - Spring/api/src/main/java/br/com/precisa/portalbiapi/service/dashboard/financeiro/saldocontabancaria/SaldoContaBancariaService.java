package br.com.precisa.portalbiapi.service.dashboard.financeiro.saldocontabancaria;

import br.com.precisa.portalbiapi.model.dashboard.financeiro.saldocontabancaria.SaldoContaBancaria;
import br.com.precisa.portalbiapi.repository.dashboard.financeiro.saldocontabancaria.SaldoContaBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaldoContaBancariaService {

    @Autowired
    private SaldoContaBancariaRepository saldoContaBancariaRepository;

    public List<SaldoContaBancaria> findById(String idEmpresa, String dataInicial) {
        return saldoContaBancariaRepository.findById(idEmpresa, dataInicial);
    }
}

