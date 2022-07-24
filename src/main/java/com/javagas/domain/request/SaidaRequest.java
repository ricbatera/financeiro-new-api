package com.javagas.domain.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class SaidaRequest {
	
	private Long id;
	private String descricao;
	private Integer qtdeParcelas;
	private Boolean parcelado;
	private Boolean custoImprevisto;
	private Boolean custoMensal;
	private LocalDate dataVencimento;
	private Boolean pago;
	private Long empresaId;
	private Long categoriaId;
	private String obs;
	private BigDecimal valorEsperado;
	private Long obraId;

}
