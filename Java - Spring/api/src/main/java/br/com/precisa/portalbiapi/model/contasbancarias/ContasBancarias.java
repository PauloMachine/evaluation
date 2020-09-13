package br.com.precisa.portalbiapi.model.contasbancarias;

import lombok.Data;

@Data
public class ContasBancarias {
    private Integer idConta;
    private Integer idContaCtb;
    private Integer limiteCtb;
    private String agencia;
    private String conta;
    private String cor;
    private String nome;
    private String nomeConta;
    private Double limite;
    private Integer stsSaldoAcu;
    private Integer stsSaldoInd;
}
