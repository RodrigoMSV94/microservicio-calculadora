package com.calculadora.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.calculadora.model.Operacion;
import com.calculadora.service.IOperacionService;

@Service
public class OperacionServiceImpl implements IOperacionService{

	@Override
	public BigDecimal execute(Operacion operacion) {
		return operacion.execute();
	}

}
