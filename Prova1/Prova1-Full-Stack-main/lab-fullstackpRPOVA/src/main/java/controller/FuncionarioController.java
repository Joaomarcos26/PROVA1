package com.exemplo.demo.controller;

import com.exemplo.demo.dto.FuncionarioCreateRequest;
import com.exemplo.demo.dto.FuncionarioResponse;
import com.exemplo.demo.exception.DepartamentoNaoEncontradoException;
import com.exemplo.demo.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping(value = "/funcionario", consumes = "application/json", produces = "application/json")
public class FuncionarioController {

    private final FuncionarioService service;

    public FuncionarioController(FuncionarioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<FuncionarioResponse> criar(@Valid @RequestBody FuncionarioCreateRequest request) {
        if (!service.departamentoExiste(request.getDepartamentoId())) {
            throw new DepartamentoNaoEncontradoException("departamento inexistente");
        }

        FuncionarioResponse response = service.criar(request);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioResponse> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioResponse> atualizar(@PathVariable Long id, @Valid @RequestBody FuncionarioCreateRequest request) {
        if (!service.departamentoExiste(request.getDepartamentoId())) {
            throw new DepartamentoNaoEncontradoException("departamento inexistente");
        }

        return service.atualizar(id, request)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (service.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}