package br.com.precisa.portalbiapi.model.configuracao;

import lombok.Data;

@Data
public class Configuracao {
    private Integer idCfg;
    private Integer diasMaxAtraso;
    private Integer numeroDup;
    private Integer desabilitarContas;
    private Double inadimplenciaLimite;
    private String meioCobBloq;
}
