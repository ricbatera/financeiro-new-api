package com.javagas.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Parcela {
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column
	private LocalDate dataVencimento;
	@Column
	private LocalDate dataPagamento;
	@Column
	private BigDecimal valorEsperado;
	@Column
	private BigDecimal valorEfetivo;
	
//	@JsonManagedReference
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "saida_id")
	private Saida saida;	
	
	
	private String status = "Aberto";


	@Override
	public String toString() {
		return "Parcela [id=" + id + ", dataVencimento=" + dataVencimento + ", dataPagamento=" + dataPagamento
				+ ", valorEsperado=" + valorEsperado + ", valorEfetivo=" + valorEfetivo
				+ ", status=" + status + "]";
	}
	
	

}