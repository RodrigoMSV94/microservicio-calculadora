package com.calculadora.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.calculadora.dto.Operador;
import com.calculadora.log.Logger;
import com.calculadora.model.Adicion;
import com.calculadora.model.Operacion;
import com.calculadora.model.Sustraccion;

@Component
public class OperacionesMapper {
	
	@Autowired
	private Logger logger;
	
	public Operacion toDTO(Operador operador, List<BigDecimal> numeros) {
		logger.log("OPERACIÓN DE " + operador);
		switch (operador) {
		case ADI:
			return new Adicion(numeros);
		default:
			return new Sustraccion(numeros);
		}
		
	}
	
}
