package com.calculadora.model;

import java.math.BigDecimal;
import java.util.List;

public class Adicion extends ListaOperacion{
	
	public Adicion(List<BigDecimal> operandos) {
        this.operandos = operandos;
    }
	
	@Override
	public BigDecimal execute() {
		return operandos.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
	}

}
