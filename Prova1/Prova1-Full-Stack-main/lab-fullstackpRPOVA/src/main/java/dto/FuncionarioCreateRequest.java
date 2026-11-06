package com.exemplo.demo.dto;

import jakarta.validation.constraints.*;

public class FuncionarioCreateRequest {

    @NotBlank(message = "o nome não pode estar em branco")
    @Size(min = 3, message = "deve ter no mínimo 3 caracteres")
    private String nome;

    @NotNull(message = "o salário é obrigatório")
    @DecimalMin(value = "1412.00", message = "deve ser >= 1412.00")
    private Double salario;

    @NotNull(message = "o departamentoId é obrigatório")
    private Long departamentoId;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Double getSalario() { return salario; }
    public void setSalario(Double salario) { this.salario = salario; }
    public Long getDepartamentoId() { return departamentoId; }
    public void setDepartamentoId(Long departamentoId) { this.departamentoId = departamentoId; }
}