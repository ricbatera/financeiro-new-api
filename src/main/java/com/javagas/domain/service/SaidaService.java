package com.javagas.domain.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javagas.domain.SaidaDTO;
import com.javagas.domain.model.Parcela;
import com.javagas.domain.model.Saida;
import com.javagas.domain.repository.CategoriaRepository;
import com.javagas.domain.repository.EmpresasJavaRepository;
import com.javagas.domain.repository.SaidaRepository;
import com.javagas.domain.request.SaidaRequest;
import com.javagas.util.Utilitarios;

@Service
public class SaidaService {
	
	@Autowired
	private EmpresasJavaRepository empresasRepo;
	
	@Autowired
	private CategoriaRepository categoriaRepo;
	
	@Autowired
	private SaidaRepository saidaRepository;
	
	public List<SaidaDTO> listarMensal(String dataBase) {
		LocalDate dataRecebida = LocalDate.parse(dataBase);
		LocalDate primeiroDiaDoMes = Utilitarios.primeiroDiaMes(dataRecebida);
		LocalDate ultimoDiaDoMes = Utilitarios.ultimoDiaMes(dataRecebida);
		List<SaidaDTO> responseList = new ArrayList<>();		
		List<Saida> lista = saidaRepository.findByParcelasDataVencimentoBetween(primeiroDiaDoMes, ultimoDiaDoMes);
		for(Saida saida : lista) {
			List<Parcela> parcelas = saida.getParcelas();
			Predicate<Parcela> filtro = p-> !((p.getDataVencimento().isAfter(primeiroDiaDoMes))&& (p.getDataVencimento().isBefore(ultimoDiaDoMes)));
			parcelas.removeIf(filtro);
			saida.setParcelas(parcelas);
			
			SaidaDTO saidaDto= new SaidaDTO();
			saidaDto.setDescricao(saida.getDescricao());
			saidaDto.setId(saida.getId());
			saidaDto.setParcela(saida.getParcelas().get(0));
			saidaDto.setSituacao(setaSituacao(saida.getParcelas().get(0)));
			responseList.add(saidaDto);			
		}
		
		
		return responseList;
	}
	
	public void novaSaida(SaidaRequest saida) {
		Saida novaSaida = new Saida();
		BeanUtils.copyProperties(saida, novaSaida);
		novaSaida.setCategoriaId(categoriaRepo.findById(saida.getCategoriaId()).get());
		novaSaida.setEmpresaId(empresasRepo.findById(saida.getEmpresaId()).get());
		novaSaida.setParcelas(gerarParcelas(saida.getQtdeParcelas(), saida.getDataVencimento(), saida.getValorEsperado(), saida.getPago()));
		saidaRepository.save(novaSaida);
		System.out.println(novaSaida.getParcelas());
	}
	
	public List<Parcela> gerarParcelas(int qtdeParcelas, LocalDate dataVencimento, BigDecimal valor, boolean marcarPago) {
		List<Parcela>parcelas = new ArrayList<>();
		Calendar vencimento = converteVencimento(dataVencimento);
		for(int i =0;  i<qtdeParcelas; i ++) {
			LocalDate venc = LocalDateTime.ofInstant(vencimento.toInstant(), vencimento.getTimeZone().toZoneId()).toLocalDate();
			Parcela parcela = new Parcela();
			parcela.setDataVencimento(venc);
			parcela.setValorEsperado(valor);
			if(marcarPago) {
				parcela.setDataPagamento(venc);
				parcela.setValorEfetivo(valor);
				parcela.setStatus("Pago");
			}
			parcelas.add(parcela);
			vencimento.set(Calendar.MONTH, (vencimento.get(Calendar.MONTH)+1));
		}
		return parcelas;
		
	}
	private Calendar converteVencimento(LocalDate vencimento) {
		String dataVencimento = vencimento.toString();
		String [] arrayVencimento = dataVencimento.split("-");
		Integer ano = Integer.valueOf(arrayVencimento[0]);
		Integer mes = Integer.valueOf(arrayVencimento[1])-1;
		Integer dia = Integer.valueOf(arrayVencimento[2]);
		Calendar vencimentoCalendar = Calendar.getInstance();		
		vencimentoCalendar.set(Calendar.DAY_OF_MONTH, dia);
		vencimentoCalendar.set(Calendar.MONTH, mes);
		vencimentoCalendar.set(Calendar.YEAR, ano);
		return vencimentoCalendar;
	}
	
	private String setaSituacao(Parcela parcela) {
		if(parcela.getDataVencimento().isBefore(LocalDate.now()) && parcela.getStatus().equals("Aberto")) {
			return "Atrasado";
		}else {
			return parcela.getStatus();
		}
	}

}
