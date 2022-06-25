package com.calculadora.exception;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import com.calculadora.controller.impl.CalculadoraControllerImpl;
import com.calculadora.mapper.OperacionesMapper;
import com.calculadora.service.IOperacionService;
import com.calculadora.service.impl.OperacionServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
@SpringBootTest
class ResponseExceptionHandlerTests {
	
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
	void operacionTest_Exception() throws Exception {
		String json = "{\"operadora\":\"ADI\",\"numeros\":[1,2,3]}";
		
		ObjectMapper mapper = new ObjectMapper();
		Object value = mapper.readValue(json, Object.class);
		
		final ResultActions result = mockMvc.perform(
				MockMvcRequestBuilders.post("/calculadora/operaciones")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(value)));
			result.andExpect(status().isInternalServerError());
			result.andExpect(jsonPath("$.mensaje").value("Error en servidor"));
	}
	
	@Test
	void operacionTest_HttpMessageNotReadableException() throws Exception {
		String json = "{\"operador\":\"ADIAS\",\"numeros\":[1,2,3]}";
		
		ObjectMapper mapper = new ObjectMapper();
		Object value = mapper.readValue(json, Object.class);
		
		final ResultActions result = mockMvc.perform(
				MockMvcRequestBuilders.post("/calculadora/operaciones")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(value)));
			result.andExpect(status().isBadRequest());
			result.andExpect(jsonPath("$.mensaje").value("Solicitud JSON con formato incorrecto"));
	}
	

}
