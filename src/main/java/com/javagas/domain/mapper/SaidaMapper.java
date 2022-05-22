package com.javagas.domain.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.javagas.domain.dto.SaidaIdDTO;
import com.javagas.domain.model.Saida;

@Component
public class SaidaMapper {
	
	private ModelMapper modelMapper = new ModelMapper();
	
	public SaidaIdDTO saidaToDto(Saida saida) {
		return modelMapper.map(saida, SaidaIdDTO.class);
	}

}
