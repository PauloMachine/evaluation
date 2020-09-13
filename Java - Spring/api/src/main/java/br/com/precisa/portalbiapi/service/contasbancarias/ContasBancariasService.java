package br.com.precisa.portalbiapi.service.contasbancarias;

import br.com.precisa.portalbiapi.model.contasbancarias.ContasBancarias;
import br.com.precisa.portalbiapi.repository.contasbancarias.ContasBancariasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContasBancariasService {

    @Autowired
    private ContasBancariasRepository contasBancariasRepository;

    public List<ContasBancarias> findAll(Integer limiteCtb) {
        return contasBancariasRepository.findAll(limiteCtb);
    }

    public ContasBancarias findById(Integer idConta) {
        return contasBancariasRepository.findById(idConta);
    }

    public int InsertOrUpdate(ContasBancarias contasBancarias) {
        Integer totalContasBancarias = contasBancariasRepository.findAllCount();

        // Verifica se atingiu o limite de contas bancarias liberadas
        if (contasBancarias.getLimiteCtb() > totalContasBancarias) {
            contasBancariasRepository.InsertOrUpdate(contasBancarias);
            return 0;
        } else {
            //Verifica se é o método update
            if (contasBancarias.getIdConta() != null) {
                //Verifica se é o update de uma conta ja criada
                ContasBancarias ctbUpdate = contasBancariasRepository.findById(contasBancarias.getIdConta());
                if (ctbUpdate != null) {
                    contasBancariasRepository.InsertOrUpdate(contasBancarias);
                    return 0;
                }
            }
        }

        return 1;
    }

    public boolean deleteById(Long idConta) {
        return contasBancariasRepository.deleteById(idConta);
    }
}
