package com.ufba.support.model;

public class Chamado {
    private long id;
    private String titulo;
    private String solicitante;
    private String setor;

    private String prioridade;
    private String status;

    public Chamado(long id, String titulo, String solicitante, String setor, String prioridade, String status) {
        this.id = id;
        this.titulo = titulo;
        this.solicitante = solicitante;
        this.setor = setor;
        this.prioridade = prioridade;
        this.status = status;
    }

    public Chamado() {
        //
    }


    // ID
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    //Título

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // Solicitante

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    // Setor

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    // Prioridade

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    // Status

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
