package com.calculadora.service;

import java.math.BigDecimal;
import com.calculadora.model.Operacion;

public interface IOperacionService {
	
	BigDecimal execute(Operacion operacion);
	
}
