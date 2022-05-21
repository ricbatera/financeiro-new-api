package com.javagas.domain.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javagas.domain.model.Saida;

public interface SaidaRepository extends JpaRepository<Saida, Long>{
	
	public List<Saida> findByParcelasDataVencimentoBetween(LocalDate inicio, LocalDate fim);
	
}
