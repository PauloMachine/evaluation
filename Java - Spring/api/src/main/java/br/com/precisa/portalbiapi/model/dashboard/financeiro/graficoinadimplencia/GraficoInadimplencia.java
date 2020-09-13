package br.com.precisa.portalbiapi.model.dashboard.financeiro.graficoinadimplencia;

import lombok.Data;

@Data
public class GraficoInadimplencia {
    private Long ano;
    private Long mes;
    private Double inadAtual;
    private Double inadMes;
    private Double faturamento;
}
