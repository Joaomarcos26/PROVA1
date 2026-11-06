package com.exemplo.demo.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleValidationExceptions(
            MethodArgumentNotValidException ex, HttpServletRequest request) {

        List fields = new ArrayList();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            Map fieldError = new HashMap();
            fieldError.put("name", error.getField());
            fieldError.put("message", error.getDefaultMessage());
            fields.add(fieldError);
        }

        Map body = new HashMap();
        body.put("error", "Invalid input");
        body.put("fields", fields);
        body.put("path", request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(DepartamentoNaoEncontradoException.class)
    public ResponseEntity handleDepartamentoNaoEncontrado(
            DepartamentoNaoEncontradoException ex, HttpServletRequest request) {

        List fields = new ArrayList();
        Map fieldError = new HashMap();
        fieldError.put("name", "departamentoId");
        fieldError.put("message", ex.getMessage());
        fields.add(fieldError);

        Map body = new HashMap();
        body.put("error", "Invalid input");
        body.put("fields", fields);
        body.put("path", request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
}