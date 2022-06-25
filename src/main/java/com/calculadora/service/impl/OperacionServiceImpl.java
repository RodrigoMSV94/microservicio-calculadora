package com.calculadora.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.calculadora.model.Operacion;
import com.calculadora.service.IOperacionService;

@Component
public class OperacionServiceImpl implements IOperacionService{

	@Override
	public BigDecimal execute(Operacion operacion) {
		return operacion.execute();
	}

}
