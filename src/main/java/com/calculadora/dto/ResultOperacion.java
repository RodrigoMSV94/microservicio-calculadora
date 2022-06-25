package com.calculadora.dto;

import java.math.BigDecimal;

public class ResultOperacion {
	
	private final BigDecimal resultado;

	public ResultOperacion(BigDecimal resultado) {
		super();
		this.resultado = resultado;
	}

	public BigDecimal getResultado() {
		return resultado;
	}
	
}
