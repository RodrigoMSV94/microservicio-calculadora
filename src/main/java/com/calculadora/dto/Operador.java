package com.calculadora.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(enumAsRef = true, description = "Operador: \n" +
        "* `ADI` - Operación aritmética para sumar una lista de numeros\n" +
        "* `SUB` - Operación aritmética para restar una lista de numeros\n" +
        "")
public enum Operador {
	ADI("+", "Operación aritmética para sumar una lista de numeros"),
	SUB("-", "Operación aritmética para restar una lista de numeros");

	private String representacion;
    private String descripcion;
    
    Operador(String representacion, String descripcion) {
    	this.representacion = representacion;
    	this.descripcion = descripcion;
	}

	Operador() {
	}
    
    
}
