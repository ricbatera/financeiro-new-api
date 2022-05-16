package com.javagas.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javagas.domain.model.Categoria;
import com.javagas.domain.model.EmpresasJavaGas;
import com.javagas.domain.model.Obra;
import com.javagas.domain.repository.CategoriaRepository;
import com.javagas.domain.repository.EmpresasJavaRepository;
import com.javagas.domain.repository.ObraRepository;

@Service
public class CadastrosService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private EmpresasJavaRepository empresasJavaRepository;
	
	@Autowired
	private ObraRepository obraRepository;
	
	public void novaCategoria(Categoria catergoria) {
		categoriaRepository.save(catergoria);
	}
	
	public void novaObra(Obra obra) {
		obraRepository.save(obra);
	}
	
	public List<Categoria> listarTodas(){
		return categoriaRepository.findByAtivoTrue();
	}
	
	public List<EmpresasJavaGas> listarEmpresas(){
		return empresasJavaRepository.findByAtivoTrue();
	}
	
	public List<Obra> listarTodasObras(){
		return obraRepository.findByAtivoTrue();
	}

}
