package com.javagas.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javagas.domain.request.SaidaRequest;
import com.javagas.domain.service.SaidaService;

@CrossOrigin
@RestController
@RequestMapping("/saida")
public class SaidaController {
	
	@Autowired
	private SaidaService saidaService;
	
	@PostMapping("/nova-saida")
	public void novaSaida(@RequestBody SaidaRequest saida) {
		saidaService.novaSaida(saida);
	}

}
