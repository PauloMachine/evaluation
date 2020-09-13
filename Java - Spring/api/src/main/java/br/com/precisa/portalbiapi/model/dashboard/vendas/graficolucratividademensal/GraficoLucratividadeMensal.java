package br.com.precisa.portalbiapi.model.dashboard.vendas.graficolucratividademensal;

import lombok.Data;

@Data
public class GraficoLucratividadeMensal {
    private int mes;
    private int ano;
    private Double faturamento;
    private Double custo;
    private Double lucroBruto;
}
