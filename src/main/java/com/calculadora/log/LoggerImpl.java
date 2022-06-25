package com.calculadora.log;

import org.springframework.stereotype.Component;
import io.corp.calculator.TracerImpl;

@Component
public class LoggerImpl implements Logger{

	private TracerImpl tracerImpl;

    public LoggerImpl() {
        this.tracerImpl = new TracerImpl();
    }

    private TracerImpl getTracerImpl() {
        return tracerImpl == null ? tracerImpl = new TracerImpl() : tracerImpl;
    }

    @Override
    public void log(String message) {
        getTracerImpl().trace(message);
    }

}
