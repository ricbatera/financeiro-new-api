package com.javagas.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javagas.domain.model.EmpresasJavaGas;

public interface EmpresasJavaRepository extends JpaRepository<EmpresasJavaGas, Long>{
	List<EmpresasJavaGas> findByAtivoTrue();
}
