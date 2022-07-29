package com.javagas.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javagas.domain.dto.EntradaDTO;
import com.javagas.domain.request.EntradaRequest;
import com.javagas.domain.service.EntradaService;

@CrossOrigin
@RestController
@RequestMapping("/entrada")
public class EntradaController {
	
	@Autowired
	private EntradaService entradaService;
	
	@GetMapping("/listarMensal")
	public List<EntradaDTO> listarMensal(@Param(value="dataBase") String dataBase){
		System.out.println(dataBase);
		return entradaService.listarMensal(dataBase);	
	}
	
	@PostMapping("/nova-entrada")
	public void novaSaida(@RequestBody EntradaRequest entrada) {
		entradaService.novaEntrada(entrada);
	}
	
//	@GetMapping("/{id}")
//	public SaidaIdDTO getSaidaById(@PathVariable Long id) {
//		return saidaService.getSaidaById(id);
//	}
//	
//	@PutMapping("pagar-parcela/{id}")
//	public void pagarParcela(@RequestBody ParcelaRequest parcela, @PathVariable Long id) {
//		saidaService.pagarParcela(parcela, id);	
//	}
//	
//	@PutMapping("/atualizarSaida")
//	public void atualizarSaida(@RequestBody AtualizaSaidaRequest payload) {
//		saidaService.atualizarSaida(payload);
//	}
}
