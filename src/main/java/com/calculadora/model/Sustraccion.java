package com.calculadora.model;

import java.math.BigDecimal;
import java.util.List;

public class Sustraccion extends ListaOperacion{
	
	public Sustraccion(List<BigDecimal> operandos) {
        this.operandos = operandos;
    }
	
	@Override
	public BigDecimal execute() {
		BigDecimal result = operandos.get(0);
		for (int i = 1; i < operandos.size(); i++) {
			result = result.subtract(operandos.get(i));
		}
		return result;
	}
	
}
