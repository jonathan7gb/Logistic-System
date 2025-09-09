package org.transportadora.model;

import java.util.Date;

public class HistoricoEntrega {

    private int id;
    private Entrega entrega;
    private Date dataAtualizacao;
    private String descricao;

    public HistoricoEntrega(Entrega entrega, Date dataAtualizacao, String descricao) {
        this.entrega = entrega;
        this.dataAtualizacao = dataAtualizacao;
        this.descricao = descricao;
    }

    public HistoricoEntrega(int id, Entrega entrega, Date dataAtualizacao, String descricao) {
        this.id = id;
        this.entrega = entrega;
        this.dataAtualizacao = dataAtualizacao;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return " - ID: " + id + " | Entrega ID: " + entrega.getId() + " | Data Atualizacao: " + dataAtualizacao + " | Descricao: " + descricao;
    }
}
