package main.model;

import org.bson.types.ObjectId;

import java.util.Date;

public class Tarefa {
    private ObjectId id;
    private String titulo;
    private String descricao;
    private String status;
    private Date dataCriacao;

    // Construtores, getters e setters

    public Tarefa() {
        this.dataCriacao = new Date();
    }

    public Tarefa(ObjectId id, String titulo, String descricao, String status) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.dataCriacao = new Date();
    }

    // Getters e Setters

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
