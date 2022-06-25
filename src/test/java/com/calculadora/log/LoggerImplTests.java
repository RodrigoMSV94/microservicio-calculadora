package com.calculadora.log;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class LoggerImplTests {
private static Logger logger;
	
	@BeforeAll
    public static void setUp() {
        logger = new LoggerImpl();
    }
	
	@Test
    public void traceTest() {
        logger.log("5");
        logger.log("text");
    }

}
