package br.com.precisa.portalbiapi.model.dashboard.vendas.rankingVendedores;

import lombok.Data;

@Data
public class RankingVendedores {
    private String nomeVendedor;
    private Double faturamento;
    private Double custo;
    private Double lucro;
    private int qtdVendida;
}
