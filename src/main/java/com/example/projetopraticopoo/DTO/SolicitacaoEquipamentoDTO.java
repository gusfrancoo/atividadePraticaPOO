package com.example.projetopraticopoo.DTO;

import java.util.Date;

public class SolicitacaoEquipamentoDTO {
    private int id;
    private String nomeColaborador;
    private String equipamento;
    private Date dataSolicitacao;

    public SolicitacaoEquipamentoDTO(int id, String nomeColaborador, String equipamento, Date dataSolicitacao) {
        this.id = id;
        this.nomeColaborador = nomeColaborador;
        this.equipamento = equipamento;
        this.dataSolicitacao = dataSolicitacao;
    }

    public int getId() {
        return id;
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
