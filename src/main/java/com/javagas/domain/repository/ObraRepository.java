package com.javagas.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javagas.domain.model.Obra;

public interface ObraRepository extends JpaRepository<Obra, Long>{
	List<Obra> findByAtivoTrue();
}
