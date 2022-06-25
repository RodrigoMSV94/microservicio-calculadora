package com.calculadora.configuration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OpenApiConfigTests {
	@Test
	public void openApiTest() {
		Assertions.assertNotNull(OpenApiConfig.openApi());
	}
}
