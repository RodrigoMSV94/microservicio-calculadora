package com.calculadora.controller.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calculadora.controller.CalculadoraController;
import com.calculadora.dto.ResultOperacion;
import com.calculadora.log.Logger;
import com.calculadora.mapper.OperacionesMapper;
import com.calculadora.model.Operacion;
import com.calculadora.model.Parametro;
import com.calculadora.service.IOperacionService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(description = "API para realizar operaciones aritméticas como suma o resta", 
	name = "Operaciones Aritméticas")
@RestController
@RequestMapping("/calculadora")
public class CalculadoraControllerImpl implements CalculadoraController{
	
	@Autowired
	private Logger logger;
	
	@Autowired
	private OperacionesMapper operacionesMapper;
	
	@Autowired
	private IOperacionService operacionService;

	@Override
	public ResponseEntity<ResultOperacion> operaciones(Parametro parametro) {
		
		Operacion operacion = operacionesMapper.toDTO(parametro.getOperador(), parametro.getNumeros());
		
		BigDecimal result = operacionService.execute(operacion);
		logger.log(result.toString());
		return new ResponseEntity<>(new ResultOperacion(result), HttpStatus.OK);
	}
	
	
	
	
}
