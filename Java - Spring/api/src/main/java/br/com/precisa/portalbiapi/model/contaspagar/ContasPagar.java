package br.com.precisa.portalbiapi.model.contaspagar;

import lombok.Data;

@Data
public class ContasPagar {
    private Long idPag;
    private Long idConta;
    private Long stsPgto;
    private Long numero;
    private Double valor;
    private String cor;
    private String corConta;
    private String razao;
    private String dtVcto;
    private String nomeReduz;
    private String observacao;
}
