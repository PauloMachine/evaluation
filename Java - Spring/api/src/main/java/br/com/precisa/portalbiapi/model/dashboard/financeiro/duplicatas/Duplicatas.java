package br.com.precisa.portalbiapi.model.dashboard.financeiro.duplicatas;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Duplicatas {
    private Long idCliente;
    private Double credito;
    private Long dupl;
    private Long parcela;
    private Long nota;
    private Double saldo;
    private Double valor;
    private LocalDate emissao;
    private LocalDate vcto;
    private String razao;
}
