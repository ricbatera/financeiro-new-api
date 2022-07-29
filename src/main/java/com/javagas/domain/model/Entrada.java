package com.javagas.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Entrada {
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column
	private String descricao;
	@Column
	private String obs;
	@ManyToOne
	private EmpresasJavaGas empresa;
	@ManyToOne
	private Obra obra;
	@Column
	private Boolean recebido;
	@Column
	private LocalDate dataVencimento;
	@Column
	private LocalDate dataRecebimento;	
	@Column
	private BigDecimal valorEsperado;	
	@Column
	private BigDecimal valorRecebido;
	
	

}
