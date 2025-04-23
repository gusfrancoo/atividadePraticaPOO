package com.example.projetopraticopoo.model;

import java.util.Date;

public class SolicitacaoEquipamento {
    private int id;
    private String nomeColaborador;
    private String equipamento;
    private Date dataSolicitacao;

    public int getId() {
        return id;
    }

    public SolicitacaoEquipamento(int id, String nomeColaborador, String equipamento, Date dataSolicitacao) {
        this.id = id;
        this.nomeColaborador = nomeColaborador;
        this.equipamento = equipamento;
        this.dataSolicitacao = dataSolicitacao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeColaborador() {
        return nomeColaborador;
    }

    public void setNomeColaborador(String nomeColaborador) {
        this.nomeColaborador = nomeColaborador;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }

    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }
}
