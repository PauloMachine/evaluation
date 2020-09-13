package br.com.precisa.portalbiapi.endpoint.empresa;

import br.com.precisa.portalbiapi.model.empresa.Empresa;
import br.com.precisa.portalbiapi.service.empresa.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("empresa")
public class EmpresaEndpoint {

    @Autowired
    private EmpresaService empresaService;

    @PostMapping("")
    public List<Empresa> findById(@RequestBody Map<String, Object> map) {
        String cnpj = (String) map.get("cnpj");
        return empresaService.findById(cnpj);
    }
}
