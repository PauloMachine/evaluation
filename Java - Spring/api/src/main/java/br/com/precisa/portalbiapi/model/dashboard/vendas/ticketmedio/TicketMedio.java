package br.com.precisa.portalbiapi.model.dashboard.vendas.ticketmedio;

import lombok.Data;

@Data
public class TicketMedio {
    private int totalVendas;
    private Double qtdVendida;
    private Double qtdProduto;
    private Double qtdProdutoVen;
    private Double faturamento;
}
