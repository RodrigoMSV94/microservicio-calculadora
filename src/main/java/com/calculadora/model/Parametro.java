package com.calculadora.model;

import java.math.BigDecimal;
import java.util.List;

import com.calculadora.dto.Operador;

public class Parametro {
	
	private Operador operador;
	private List<BigDecimal> numeros;
	
	public Parametro(Operador operador, List<BigDecimal> numeros) {
		this.operador = operador;
		this.numeros = numeros;
	}

	public Operador getOperador() {
		return operador;
	}

	public void setOperador(Operador operador) {
		this.operador = operador;
	}

	public List<BigDecimal> getNumeros() {
		return numeros;
	}
	
	public void setNumeros(List<BigDecimal> numeros) {
		this.numeros = numeros;
	}
	
}
