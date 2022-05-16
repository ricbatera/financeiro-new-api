package com.javagas.domain.request;

import java.time.LocalDate;

import lombok.Data;

@Data
public class SaidaRequest {
	
	private Integer id;
	private String descricao;
	private Integer qtdeParcelas;
	private Boolean parcelado;
	private Boolean custoImprevisto;
	private Boolean custoMensal;
	private LocalDate vencimento;
	private Boolean pago;
	private Integer empresaId;
	private Integer categoriaId;

}
