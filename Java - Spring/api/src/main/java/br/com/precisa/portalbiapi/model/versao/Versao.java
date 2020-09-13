package br.com.precisa.portalbiapi.model.versao;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class Versao {
    private LocalDate dataTransmissao;
    private LocalTime horaTransmissao;
    private Long versaoTransmissao;
}
