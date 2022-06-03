package com.javagas.domain.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class ParcelaRequest {
	
	private Long id;
	private LocalDate dataVencimento;
	private LocalDate dataPagamento;
	private BigDecimal valorEsperado;
	private BigDecimal valorEfetivo;
}
