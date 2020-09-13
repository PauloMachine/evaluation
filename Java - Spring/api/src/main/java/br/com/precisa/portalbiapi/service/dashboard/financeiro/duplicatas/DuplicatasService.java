package br.com.precisa.portalbiapi.service.dashboard.financeiro.duplicatas;

import br.com.precisa.portalbiapi.model.dashboard.financeiro.duplicatas.Duplicatas;
import br.com.precisa.portalbiapi.repository.dashboard.financeiro.duplicatas.DuplicatasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class DuplicatasService {

    @Autowired
    private DuplicatasRepository duplicatasRepository;

    public long findAllCount(String idEmpresa, String dataInicial, String dataFinal) {
        return duplicatasRepository.findAllCount(idEmpresa, dataInicial, dataFinal);
    }

    public double findAllSum(String idEmpresa, String dataInicial, String dataFinal) {
        return duplicatasRepository.findAllSum(idEmpresa, dataInicial, dataFinal);
    }

    public List<Duplicatas> findById(String idEmpresa, Long page, Long size, String dataInicial, String dataFinal) {

        // O default do gráfico deve ser os registros de um mês atrás, partindo da data atual.
        if((dataInicial == "") || (dataFinal == "")) {
            dataInicial = LocalDate.now().minusMonths(1).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            dataFinal = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }

        return duplicatasRepository.findById(idEmpresa, page, size, dataInicial, dataFinal);
    }
}
