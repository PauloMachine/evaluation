package br.com.precisa.portalbiapi.model.dashboard.financeiro.extratocontabancaria;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ExtratoContaBancaria {
    private Double credito;
    private Double debito;
    private Long tipoTotal;
    private Double saldo;
    private LocalDate dataLanc;
    private String historico;
    private String complemento;
}
