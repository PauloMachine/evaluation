package br.com.precisa.portalbiapi.service.contaspagar;

import br.com.precisa.portalbiapi.model.contaspagar.ContasPagar;
import br.com.precisa.portalbiapi.repository.contaspagar.ContasPagarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContasPagarService {

    @Autowired
    private ContasPagarRepository contasPagarRepository;

    public List<ContasPagar> findAll() {
        return contasPagarRepository.findAll();
    }

    public int findAllCount() {
        return contasPagarRepository.findAllCount();
    }

    public int InsertOrUpdate(ContasPagar contasPagar) {
        return contasPagarRepository.InsertOrUpdate(contasPagar);
    }

    public void updateById(Long idPag) {
        contasPagarRepository.updateById(idPag);
    }

    public ContasPagar findById(Long idPag) {
        return contasPagarRepository.findById(idPag);
    }

    public boolean deleteById(Long idConta) {
        return contasPagarRepository.deleteById(idConta);
    }
}
