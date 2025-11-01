package com.saboresdomundo.model;

public class Produto {
    private int id;
    private String nome;
    private String categoria;
    private int quantidade;
    private String unidade;

    public Produto() {}

    public Produto(int id, String nome, String categoria, int quantidade, String unidade) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.unidade = unidade;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getCategoria() { return categoria; }
    public int getQuantidade() { return quantidade; }
    public String getUnidade() { return unidade; }

    public void setId(int id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    public void setUnidade(String unidade) { this.unidade = unidade; }
}