package com.exemplo.demo.exception;

public class DepartamentoNaoEncontradoException extends RuntimeException {
    public DepartamentoNaoEncontradoException(String message) {
        super(message);
    }
}