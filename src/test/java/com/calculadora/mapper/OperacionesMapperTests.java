package com.calculadora.mapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.calculadora.dto.Operador;
import com.calculadora.model.Adicion;
import com.calculadora.model.Operacion;
import com.calculadora.model.Sustraccion;

@SpringBootTest
class OperacionesMapperTests {
	
	@Autowired
	private OperacionesMapper operacionMapper;
	
	@Test
	void adicionOperacionDTOTest() {
		Operacion operacion = operacionMapper.toDTO(Operador.ADI, listaNumeros());
		Assertions.assertTrue(operacion instanceof Adicion);
	}
	
	@Test
    void sustraccionOperacionDTOTest() {
        Operacion operacion = operacionMapper.toDTO(Operador.SUB, listaNumeros());
		Assertions.assertTrue(operacion instanceof Sustraccion);
    }
	
	List<BigDecimal> listaNumeros(){
		List<BigDecimal> listNumeros = new ArrayList<BigDecimal>();
		listNumeros.add(new BigDecimal(1));
		listNumeros.add(new BigDecimal(2));
		listNumeros.add(new BigDecimal(3));
		return listNumeros;
	}

}
