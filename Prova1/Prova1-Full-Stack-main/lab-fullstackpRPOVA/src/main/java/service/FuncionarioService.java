package com.exemplo.demo.service;

import com.exemplo.demo.dto.DepartamentoResponse;
import com.exemplo.demo.dto.FuncionarioCreateRequest;
import com.exemplo.demo.dto.FuncionarioResponse;
import java.util.List;
import java.util.Optional;

public interface FuncionarioService {
    List<DepartamentoResponse> listarDepartamentos(String nome);
    List<FuncionarioResponse> listarFuncionariosPorDepartamento(Long departamentoId);
    FuncionarioResponse criar(FuncionarioCreateRequest request);
    Optional<FuncionarioResponse> buscarPorId(Long id);
    Optional<FuncionarioResponse> atualizar(Long id, FuncionarioCreateRequest request);
    boolean eliminar(Long id);
    boolean departamentoExiste(Long id);
}