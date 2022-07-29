package com.javagas.domain.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javagas.domain.model.Entrada;

public interface EntradaRepository extends JpaRepository<Entrada, Long>{
	
	public List<Entrada> findByDataVencimentoBetween(LocalDate inicio, LocalDate fim);
}
