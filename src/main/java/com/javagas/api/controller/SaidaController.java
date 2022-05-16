package com.javagas.api.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javagas.domain.request.SaidaRequest;

@CrossOrigin
@RestController
@RequestMapping("/saida")
public class SaidaController {
	
	@PostMapping("/nova-saida")
	public void novaSaida(@RequestBody SaidaRequest payload) {
		System.out.println(payload);
	}

}
