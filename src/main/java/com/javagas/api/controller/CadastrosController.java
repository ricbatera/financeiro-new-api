package com.javagas.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javagas.domain.model.Categoria;
import com.javagas.domain.model.EmpresasJavaGas;
import com.javagas.domain.model.Obra;
import com.javagas.domain.service.CadastrosService;

@CrossOrigin
@RestController
@RequestMapping("/cadastro")
public class CadastrosController {
	
	@Autowired
	private CadastrosService cadastrosService;
	
	@PostMapping("/categoria")
	public void novaCategoria(@RequestBody Categoria categoria) {
		cadastrosService.novaCategoria(categoria);
	}
	
	@PostMapping("/obra")
	public void novaObra(@RequestBody Obra obra) {
		cadastrosService.novaObra(obra);
	}
	
	@GetMapping("/categoria/listar")
	public List<Categoria> listarTodas(){
		return cadastrosService.listarTodas();
	}

	@GetMapping("/empresas-java/listar")
	public List<EmpresasJavaGas> listarTodasEmpresas(){
		return cadastrosService.listarEmpresas();
	}
	
	@GetMapping("/obra/listar")
	public List<Obra> listarTodasObras(){
		return cadastrosService.listarTodasObras();
	}

}
