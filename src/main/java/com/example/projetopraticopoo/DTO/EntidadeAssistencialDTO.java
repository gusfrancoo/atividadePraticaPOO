package com.example.projetopraticopoo.DTO;

public class EntidadeAssistencialDTO {
    private int id;
    private String nome;
    private String cnpj;
    private String tipo;

    public EntidadeAssistencialDTO(int id, String nome, String cnpj, String tipo) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.tipo = tipo;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
