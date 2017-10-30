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
public class Servicos {

    /**
     * @return the tarefa
     */
   

     private int codigo ;
     private String nome;    
     private Date dataHotario;
     private boolean status;
     private Funcionario funcionario ;    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

  
   
  

    public Date getDataHotario() {
        return dataHotario;
    }

    public void setDataHotario(Date DataHotario) {
        this.dataHotario = DataHotario;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    
   
}
