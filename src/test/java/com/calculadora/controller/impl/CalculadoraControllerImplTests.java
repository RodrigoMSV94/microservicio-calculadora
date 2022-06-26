package com.calculadora.controller.impl;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.calculadora.dto.Operador;
import com.calculadora.mapper.OperacionesMapper;
import com.calculadora.model.Parametro;
import com.calculadora.service.IOperacionService;
import com.calculadora.service.impl.OperacionServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
@SpringBootTest
class CalculadoraControllerImplTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	@InjectMocks
	private static CalculadoraControllerImpl calculadoraController;
	
	@Mock
	private IOperacionService operacionService = mock(OperacionServiceImpl.class);
	
	@Mock
	private OperacionesMapper operacionesMapper = mock(OperacionesMapper.class);
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	void operacionSumarTest() throws Exception{
		Parametro parametros = new Parametro(Operador.ADI, listaNumeros());
		
		final ResultActions result = mockMvc.perform(
				MockMvcRequestBuilders.post("/calculadora/operaciones")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(parametros)));
			result.andExpect(status().isOk());
			result.andExpect(jsonPath("$.resultado").value(6));

	}
	
	@Test
	void operacionRestarTest() throws Exception{
		Parametro parametros = new Parametro(Operador.SUB, listaNumeros());
		
		final ResultActions result = mockMvc.perform(
				MockMvcRequestBuilders.post("/calculadora/operaciones")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(parametros)));
			result.andExpect(status().isOk());
			result.andExpect(jsonPath("$.resultado").value(-4));

	}
	
	List<BigDecimal> listaNumeros(){
		List<BigDecimal> listNumeros = new ArrayList<BigDecimal>();
		listNumeros.add(new BigDecimal(1));
		listNumeros.add(new BigDecimal(2));
		listNumeros.add(new BigDecimal(3));
		return listNumeros;
	}

}
