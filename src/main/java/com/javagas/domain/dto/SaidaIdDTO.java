package com.javagas.domain.dto;

import java.math.BigDecimal;
import java.util.List;

import com.javagas.domain.model.Categoria;
import com.javagas.domain.model.EmpresasJavaGas;
import com.javagas.domain.model.Obra;
import com.javagas.domain.model.Parcela;

import lombok.Data;

@Data
public class SaidaIdDTO {
	private Long id;	
	private String descricao;	
	private Boolean custoImprevisto;	
	private Boolean custoMensal;	
	private String obs;	
	private Categoria categoriaId;	
	private EmpresasJavaGas empresaId;	
	private List<Parcela> parcelas;
	private Obra obraId;
	
	//campos calculados
	private BigDecimal valorTotal;
	private BigDecimal totalPago;
	private BigDecimal totalAberto;
	private Long qtdeParcelas;
	private Long parcelasPagas;
	private Long parcelasAbertas;
	private Parcela parcelaAtual;
	
}
