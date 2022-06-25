package com.calculadora.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.calculadora.dto.RespuestaBase;
import com.calculadora.dto.ResultOperacion;
import com.calculadora.model.Parametro;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface CalculadoraController {
	
	@Operation(summary = "Sumar o Restar numeros decimales",
			description = "Proporciona el resultado de la suma o resta de una lista de numeros", tags = "Post")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "${api.response-codes.ok.desc}",
					content = {@Content( mediaType = "application/json",
							schema = @Schema(implementation = Parametro.class))}),
			@ApiResponse(responseCode = "400", description = "${api.response-codes.badRequest.desc}"),
			@ApiResponse(responseCode = "404", description = "${api.response-codes.notFound.desc}")
	})   
	@PostMapping("/operaciones")
	ResponseEntity<RespuestaBase<ResultOperacion>> operaciones(@RequestBody Parametro parametro);
}
