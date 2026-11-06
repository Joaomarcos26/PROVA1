package com.exemplo.demo.dto;

public class FuncionarioResponse {
    private Long id;
    private String nome;
    private Double salario;
    private Long departamentoId;

    public FuncionarioResponse(Long id, String nome, Double salario, Long departamentoId) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
        this.departamentoId = departamentoId;
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public Double getSalario() { return salario; }
    public Long getDepartamentoId() { return departamentoId; }
}