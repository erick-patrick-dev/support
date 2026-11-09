package com.ufba.support.model;

public class Chamado {
    private Long id;
    private String titulo;
    private String solicitante;
    private String setor;

    private Prioridade prioridade;
    private Status status;

    public Chamado(Long id, String titulo, String solicitante, String setor, Prioridade prioridade, Status status) {
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
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    // Status

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
