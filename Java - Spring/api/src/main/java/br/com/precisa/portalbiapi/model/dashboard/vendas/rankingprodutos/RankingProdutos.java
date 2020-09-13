package br.com.precisa.portalbiapi.model.dashboard.vendas.rankingprodutos;

import lombok.Data;

@Data
public class RankingProdutos {
    private String nomeProduto;
    private Double faturamento;
    private Double custo;
    private Double lucro;
    private Integer qtdVendida;
}
