package com.calculadora.dto;

public enum Operador {
	ADI("+", "Operación aritmética para sumar una lista de numeros"),
    SUB("-", "Operación aritmética para sumar una lista de numeros");

	private String representacion;
    private String descripcion;
    
    Operador(String representacion, String descripcion) {
    	this.representacion = representacion;
    	this.descripcion = descripcion;
	}

	Operador() {
	}
    
    
}
