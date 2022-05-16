package com.javagas.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javagas.domain.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	List<Categoria> findByAtivoTrue();
}
