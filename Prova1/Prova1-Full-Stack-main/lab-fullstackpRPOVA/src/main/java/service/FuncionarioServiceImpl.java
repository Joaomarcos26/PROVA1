package com.exemplo.demo.service;

import com.exemplo.demo.dto.DepartamentoResponse;
import com.exemplo.demo.dto.FuncionarioCreateRequest;
import com.exemplo.demo.dto.FuncionarioResponse;
import com.exemplo.demo.mapper.FuncionarioMapper;
import com.exemplo.demo.model.Departamento;
import com.exemplo.demo.model.Funcionario;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    private final List<Departamento> departamentos = new ArrayList<>();
    private final List<Funcionario> funcionarios = new ArrayList<>();
    private Long contadorFuncionario = 3L;

    public FuncionarioServiceImpl() {
        departamentos.add(new Departamento(1L, "Tecnologia"));
        departamentos.add(new Departamento(2L, "Recursos Humanos"));
        departamentos.add(new Departamento(3L, "Financeiro"));

        funcionarios.add(new Funcionario(1L, "Alice Silva", 7500.00, 1L));
        funcionarios.add(new Funcionario(2L, "Carlos Souza", 4200.00, 2L));
        funcionarios.add(new Funcionario(3L, "Marcos Paulo", 6100.00, 3L));
    }

    @Override
    public boolean departamentoExiste(Long id) {
        return departamentos.stream().anyMatch(d -> d.getId().equals(id));
    }

    @Override
    public List<DepartamentoResponse> listarDepartamentos(String nome) {
        return departamentos.stream()
                .filter(d -> nome == null || d.getNome().toLowerCase().contains(nome.toLowerCase()))
                .map(d -> new DepartamentoResponse(d.getId(), d.getNome()))
                .collect(Collectors.toList());
    }

    @Override
    public List<FuncionarioResponse> listarFuncionariosPorDepartamento(Long departamentoId) {
        return funcionarios.stream()
                .filter(f -> f.getDepartamentoId().equals(departamentoId))
                .map(FuncionarioMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public FuncionarioResponse criar(FuncionarioCreateRequest request) {
        contadorFuncionario++;
        Funcionario funcionario = FuncionarioMapper.toEntity(contadorFuncionario, request);
        funcionarios.add(funcionario);
        return FuncionarioMapper.toResponse(funcionario);
    }

    @Override
    public Optional<FuncionarioResponse> buscarPorId(Long id) {
        return funcionarios.stream()
                .filter(f -> f.getId().equals(id))
                .map(FuncionarioMapper::toResponse)
                .findFirst();
    }

    @Override
    public Optional<FuncionarioResponse> atualizar(Long id, FuncionarioCreateRequest request) {
        for (int i = 0; i < funcionarios.size(); i++) {
            Funcionario f = funcionarios.get(i);
            if (f.getId().equals(id)) {
                Funcionario atualizado = new Funcionario(id, request.getNome(), request.getSalario(), request.getDepartamentoId());
                funcionarios.set(i, atualizado);
                return Optional.of(FuncionarioMapper.toResponse(atualizado));
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean eliminar(Long id) {
        return funcionarios.removeIf(f -> f.getId().equals(id));
    }
}