package br.com.precisa.portalbiapi.endpoint.dashboard.vendas.ticketmedio;

import br.com.precisa.portalbiapi.model.dashboard.vendas.ticketmedio.TicketMedio;
import br.com.precisa.portalbiapi.service.dashboard.vendas.ticketmedio.TicketMedioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("ticketmedio")
public class TicketMedioEndpoint {

    @Autowired
    private TicketMedioService ticketMedioService;

    @GetMapping("")
    public List<TicketMedio> find(@RequestParam("empresa") String idEmpresa,
                                        @RequestParam("dataInicial") String dataInicial,
                                        @RequestParam("dataFinal") String dataFinal) {

        return ticketMedioService.find(idEmpresa, dataInicial, dataFinal);
    }

}
