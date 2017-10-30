/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hotel.models;

import java.util.Date;

/**
 *
 * @author EDSON
 */
public class Tarefa {
    
    private int codigo ;
    private String nome;
    private String descricao;
    private Date data;
    private Servicos servico;

    public Tarefa() {
    }

    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

   
    public Servicos getServico() {
        return servico;
    }

    public void setServico(Servicos servico) {
        this.servico = servico;
    }

    @Override
    public String toString() {
        return "Tarefa{" + "codigo=" + codigo + ", nome=" + nome + ", descricao=" + descricao + ", data=" + data + ", servico=" + servico.getCodigo() + '}';
    }

   
    
    
}
