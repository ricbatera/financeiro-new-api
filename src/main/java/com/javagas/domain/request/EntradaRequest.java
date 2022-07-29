package com.javagas.domain.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class EntradaRequest {
	
	private Long id;
	private String descricao;
	private LocalDate dataVencimento;
	private Boolean recebido;
	private Long empresaId;
	private Long categoriaId;
	private String obs;
	private BigDecimal valorEsperado;
	private Long obraId;

}
