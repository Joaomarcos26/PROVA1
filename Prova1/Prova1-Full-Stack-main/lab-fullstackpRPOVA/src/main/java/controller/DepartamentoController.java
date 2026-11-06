package com.exemplo.demo.controller;

import com.exemplo.demo.dto.DepartamentoResponse;
import com.exemplo.demo.dto.FuncionarioResponse;
import com.exemplo.demo.service.FuncionarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

    private final FuncionarioService service;

    public DepartamentoController(FuncionarioService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<DepartamentoResponse>> listar(@RequestParam(required = false) String nome) {
        return ResponseEntity.ok(service.listarDepartamentos(nome));
    }

    @GetMapping("/{id}/funcionario")
    public ResponseEntity<List<FuncionarioResponse>> listarFuncionarios(@PathVariable Long id) {
        return ResponseEntity.ok(service.listarFuncionariosPorDepartamento(id));
    }
}