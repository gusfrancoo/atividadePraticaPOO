package com.example.projetopraticopoo.model;

import java.util.Date;

public class Doacao {
    private int id;
    private String doador;
    private String entidade;
    private String itemDoador;
    private int quantidade;
    private Date dataDoacao;

    public Doacao(int id, String doador, String entidade, String itemDoador, int quantidade, Date dataDoacao) {
        this.id = id;
        this.doador = doador;
        this.entidade = entidade;
        this.itemDoador = itemDoador;
        this.quantidade = quantidade;
        this.dataDoacao = dataDoacao;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDoador() {
        return doador;
    }

    public void setDoador(String doador) {
        this.doador = doador;
    }

    public String getEntidade() {
        return entidade;
    }

    public void setEntidade(String entidade) {
        this.entidade = entidade;
    }

    public String getItemDoador() {
        return itemDoador;
    }

    public void setItemDoador(String itemDoador) {
        this.itemDoador = itemDoador;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Date getDataDoacao() {
        return dataDoacao;
    }

    public void setDataDoacao(Date dataDoacao) {
        this.dataDoacao = dataDoacao;
    }
}
