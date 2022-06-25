package com.calculadora.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.calculadora.model.Adicion;
import com.calculadora.model.Sustraccion;

@SpringBootTest
class OperacionServiceImplTests {

	@Autowired
	@InjectMocks
	private static OperacionServiceImpl service;
	
	@Test
	void operacionExecuteAdicionTest() {
		Assertions.assertEquals(service.execute(new Adicion(listaNumeros())), new BigDecimal(6));
	}
	
	@Test
	void operacionExecuteSustraccionTest() {
		Assertions.assertEquals(service.execute(new Sustraccion(listaNumeros())), new BigDecimal(-4));
	}
	
	List<BigDecimal> listaNumeros(){
		List<BigDecimal> listNumeros = new ArrayList<BigDecimal>();
		listNumeros.add(new BigDecimal(1));
		listNumeros.add(new BigDecimal(2));
		listNumeros.add(new BigDecimal(3));
		return listNumeros;
	}

}
