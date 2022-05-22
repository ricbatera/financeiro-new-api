package com.javagas.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.javagas.domain.model.Parcela;

import lombok.Data;

@Data
public class SaidaDTO {
	
	Long id;
	private String descricao;
//	private Parcela parcela;
	private LocalDate vencimento;
	private BigDecimal valor;
	private String situacao;
	private Long idParcelaAtual;

}
