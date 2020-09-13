package br.com.precisa.portalbiapi.model.dashboard.vendas.produtosnaovendidos;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ProdutosNaoVendidos {
    private Integer idItem;
    private String nomeProduto;
    private String undVen;
    private LocalDate dtCad;
    private LocalDate ultVenda;
    private Double saldo;
}
