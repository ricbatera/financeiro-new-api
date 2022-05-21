package com.javagas.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
public class Saida {
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column
	private String descricao;
	@Column
	private Boolean custoImprevisto;
	@Column
	private Boolean custoMensal;
	@Column
	private String obs;
	@ManyToOne
	private Categoria categoriaId;
	@ManyToOne
	private EmpresasJavaGas empresaId;
	@JsonManagedReference
	@OneToMany(mappedBy = "saida", cascade = CascadeType.ALL)
	private List<Parcela> parcelas;
	
	@PrePersist
	public void setaEntradaSaidaNaLista() {
		parcelas.forEach(i -> i.setSaida(this));
	}
	
	

}
