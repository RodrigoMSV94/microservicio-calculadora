package com.calculadora.dto;

import io.swagger.v3.oas.annotations.media.Schema;


@Schema
public class RespuestaBase<T> {
	
	@Schema
	private final T data;
	
	public RespuestaBase(T data) {
		super();
		this.data = data;
	}

	public T getData() {
		return data;
	}
	
	
	
}
