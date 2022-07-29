package com.javagas.domain.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javagas.domain.dto.EntradaDTO;
import com.javagas.domain.model.Entrada;
import com.javagas.domain.repository.EmpresasJavaRepository;
import com.javagas.domain.repository.EntradaRepository;
import com.javagas.domain.repository.ObraRepository;
import com.javagas.domain.request.EntradaRequest;
import com.javagas.util.Utilitarios;

@Service
public class EntradaService {
	
	@Autowired
	private EntradaRepository entradaRepository;
	
	@Autowired
	private ObraRepository obraRepository;
	
	@Autowired
	private EmpresasJavaRepository empresasRepo;
	
	private LocalDate dataRecebida;
	
	
	public void novaEntrada(EntradaRequest entrada) {
		Entrada novaEntrada = new Entrada();
		BeanUtils.copyProperties(entrada, novaEntrada);
		novaEntrada.setEmpresa(empresasRepo.getById(entrada.getEmpresaId()));
		novaEntrada.setObra(obraRepository.getById(entrada.getObraId()));
		if(entrada.getRecebido()) {
			novaEntrada.setDataRecebimento(entrada.getDataVencimento());
			novaEntrada.setValorRecebido(entrada.getValorEsperado());
		}
		entradaRepository.save(novaEntrada);
	}
	
	public List<EntradaDTO> listarMensal(String dataBase){
		dataRecebida = LocalDate.parse(dataBase);
		LocalDate hoje = LocalDate.now();
		LocalDate primeiroDiaDoMes = Utilitarios.primeiroDiaMes(dataRecebida);
		LocalDate ultimoDiaDoMes = Utilitarios.ultimoDiaMes(dataRecebida);
		List<Entrada> lista = entradaRepository.findByDataVencimentoBetween(primeiroDiaDoMes, ultimoDiaDoMes);
		List<EntradaDTO> responseList = new ArrayList<>();
		for(Entrada entrada : lista) {
			EntradaDTO dto = new EntradaDTO();
			BeanUtils.copyProperties(entrada, dto);
			
			if(entrada.getRecebido()) {
				dto.setSituacao("Recebido");
			}else if(entrada.getDataVencimento().isAfter(hoje)) {
				dto.setSituacao("A Receber");
			}else if(entrada.getDataVencimento().isEqual(hoje)){
				dto.setSituacao("Previsto para hoje");
			}else{
				dto.setSituacao("Atrasado");
			}
			responseList.add(dto);
		}
		return responseList;
	}

}
