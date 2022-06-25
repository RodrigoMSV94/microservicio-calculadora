package com.calculadora.exception;

public class OperatNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public OperatNotFoundException(String mensaje) {
		super(mensaje);
	}
	
}
