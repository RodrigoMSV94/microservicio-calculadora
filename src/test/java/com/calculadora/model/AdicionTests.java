package com.calculadora.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AdicionTests {
	
	public static Operacion operacion;
	
	@Test
	void executeTest() {
		List<BigDecimal> listNumeros = new ArrayList<BigDecimal>();
		listNumeros.add(new BigDecimal(1));
		listNumeros.add(new BigDecimal(2));
		listNumeros.add(new BigDecimal(3));
		operacion = new Adicion(listNumeros);
        Assertions.assertEquals(operacion.execute(), new BigDecimal(6));
	}

}
