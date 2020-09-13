package br.com.precisa.portalbiapi.model.resumocontas;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ResumoContas {
    private Long idPag;
    private Long stsPgto;
    private Long numero;
    private String cor;
    private String razao;
    private String fantasia;
    private String tipo;
    private String conta;
    private String observacao;
    private Double saldo;
    private LocalDate vcto;
}
