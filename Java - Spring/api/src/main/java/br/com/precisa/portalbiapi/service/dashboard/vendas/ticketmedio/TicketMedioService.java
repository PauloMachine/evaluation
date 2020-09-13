package br.com.precisa.portalbiapi.service.dashboard.vendas.ticketmedio;

import br.com.precisa.portalbiapi.model.dashboard.vendas.ticketmedio.TicketMedio;
import br.com.precisa.portalbiapi.repository.dashboard.vendas.ticketmedio.TicketMedioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketMedioService {

    @Autowired
    private TicketMedioRepository ticketMedioRepository;

    public List<TicketMedio> find(String idEmpresa, String dataInicial, String dataFinal) {
        return ticketMedioRepository.find(idEmpresa, dataInicial, dataFinal);
    }

}
