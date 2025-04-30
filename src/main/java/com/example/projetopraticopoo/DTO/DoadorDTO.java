package com.example.projetopraticopoo.DTO;

public class DoadorDTO {
    private int id;
    private String nomeDoador;
    private Long telefone;
    private String email;

    public DoadorDTO(int id, String nomeDoador, long telefone, String email) {
        this.id = id;
        this.nomeDoador = nomeDoador;
        this.telefone = telefone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeDoador() {
        return nomeDoador;
    }

    public void setNomeDoador(String nomeDoador) {
        this.nomeDoador = nomeDoador;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
