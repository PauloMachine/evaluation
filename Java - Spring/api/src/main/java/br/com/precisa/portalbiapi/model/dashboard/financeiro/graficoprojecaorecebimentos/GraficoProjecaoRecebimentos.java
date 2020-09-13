package br.com.precisa.portalbiapi.model.dashboard.financeiro.graficoprojecaorecebimentos;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class GraficoProjecaoRecebimentos {
    private LocalDate data;
    private LocalDate dataTransmissao;
    private LocalTime horaTransmissao;
    private Long versaoTransmissao;
    private String tipo;
    private Double duplicataClientesBons;
    private Double valorRecebidoDia;
    private Double duplicataPagarDia;
    private Double chequePagarDia;
}
