package br.com.precisa.portalbiapi.model.dashboard.financeiro.graficosaldobancario;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GraficoSaldoBancario {
    private LocalDate data;
    private Double saldoCta;
    private Double saldoPagarDia;
    private Double saldoPagarAcumulado;
}
