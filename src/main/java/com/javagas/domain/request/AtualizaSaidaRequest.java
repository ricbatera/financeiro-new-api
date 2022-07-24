package com.javagas.domain.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class AtualizaSaidaRequest {
	private Long id;
	private Boolean atualizarValorParcelasFuturas = false;
	private Long categoriaId;
	private Long empresaId;
	private String descricao;
	private String obs;
	private BigDecimal valorEsperado;
	private LocalDate dataVencimento;
	private Long idParcelaAtual;
}
