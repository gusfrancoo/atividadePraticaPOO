package com.example.projetopraticopoo.model;

import java.util.Date;

public class Doador {
    private int id;
    private String nomeDoador;
    private int telefone;
    private String email;

    public int getId() {
        return id;
    }

    public Doador(int id, String nomeDoador, int telefone, String email) {
        this.id = id;
        this.nomeDoador = nomeDoador;
        this.telefone = telefone;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomeDoador() {
        return nomeDoador;
    }

    public void setNomeDoador(String nomeDoador) {
        this.nomeDoador = nomeDoador;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }


}
