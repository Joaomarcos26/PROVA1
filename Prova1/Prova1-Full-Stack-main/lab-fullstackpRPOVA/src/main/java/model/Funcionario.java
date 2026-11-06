package com.exemplo.demo.model;

public class Funcionario {
    private Long id;
    private String nome;
    private Double salario;
    private Long departamentoId;

    public Funcionario(Long id, String nome, Double salario, Long departamentoId) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
        this.departamentoId = departamentoId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Double getSalario() { return salario; }
    public void setSalario(Double salario) { this.salario = salario; }
    public Long getDepartamentoId() { return departamentoId; }
    public void setDepartamentoId(Long departamentoId) { this.departamentoId = departamentoId; }
}