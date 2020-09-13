package br.com.precisa.portalbiapi.model.dashboard.financeiro.saldocontabancaria;

import lombok.Data;

@Data
public class SaldoContaBancaria {
    private Long idConta;
    private Double saldo;
    private String nomeConta;
    private String classificacao;
    private String cor;
    private String limite;
}
