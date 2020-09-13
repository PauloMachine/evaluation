package br.com.precisa.portalbiapi.service.empresa;

import br.com.precisa.portalbiapi.model.empresa.Empresa;
import br.com.precisa.portalbiapi.repository.empresa.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<Empresa> findById(String cnpj) {
        return empresaRepository.findById(cnpj);
    }
}
