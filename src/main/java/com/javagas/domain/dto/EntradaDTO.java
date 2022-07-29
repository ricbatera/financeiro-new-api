package com.javagas.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.javagas.domain.model.EmpresasJavaGas;
import com.javagas.domain.model.Obra;
import com.javagas.domain.model.Parcela;

import lombok.Data;

@Data
public class EntradaDTO {
	
	Long id;
	private String descricao;
	private LocalDate dataVencimento;
	private LocalDate dataRecebimento;
	private BigDecimal valorEsperado;
	private BigDecimal valorRecebido;
	private EmpresasJavaGas empresa;
	private Obra obra;
	private String obs;
	private String situacao;

}
