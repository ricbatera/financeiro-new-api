package com.javagas.api.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javagas.domain.dto.SaidaDTO;
import com.javagas.domain.dto.SaidaIdDTO;
import com.javagas.domain.model.Saida;
import com.javagas.domain.request.SaidaRequest;
import com.javagas.domain.service.SaidaService;

@CrossOrigin
@RestController
@RequestMapping("/saida")
public class SaidaController {
	
	@Autowired
	private SaidaService saidaService;
	
	@GetMapping("/listarMensal")
	public List<SaidaDTO> listarMensal(@Param(value="dataBase") String dataBase){
		System.out.println(dataBase);
		return saidaService.listarMensal(dataBase);	
	}
	
	@PostMapping("/nova-saida")
	public void novaSaida(@RequestBody SaidaRequest saida) {
		saidaService.novaSaida(saida);
	}
	
	@GetMapping("/{id}")
	public SaidaIdDTO getSaidaById(@PathVariable Long id) {
		return saidaService.getSaidaById(id);
	}

}
