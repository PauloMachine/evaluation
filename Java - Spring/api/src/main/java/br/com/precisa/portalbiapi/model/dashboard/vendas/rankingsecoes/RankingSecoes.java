package br.com.precisa.portalbiapi.model.dashboard.vendas.rankingsecoes;

import lombok.Data;

@Data
public class RankingSecoes {
    private String nomeSecao;
    private Double faturamento;
    private Double custo;
    private Double lucro;
    private int qtdVendida;
}
