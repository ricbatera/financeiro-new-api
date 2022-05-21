package com.javagas.domain;

import com.javagas.domain.model.Parcela;

import lombok.Data;

@Data
public class SaidaDTO {
	
	Long id;
	private String descricao;
	private Parcela parcela;
	private String situacao;

}
