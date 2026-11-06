package com.exemplo.demo.mapper;

import com.exemplo.demo.dto.FuncionarioCreateRequest;
import com.exemplo.demo.dto.FuncionarioResponse;
import com.exemplo.demo.model.Funcionario;

public class FuncionarioMapper {
    public static Funcionario toEntity(Long id, FuncionarioCreateRequest request) {
        return new Funcionario(id, request.getNome(), request.getSalario(), request.getDepartamentoId());
    }

    public static FuncionarioResponse toResponse(Funcionario funcionario) {
        return new FuncionarioResponse(
                funcionario.getId(),
                funcionario.getNome(),
                funcionario.getSalario(),
                funcionario.getDepartamentoId()
        );
    }
}