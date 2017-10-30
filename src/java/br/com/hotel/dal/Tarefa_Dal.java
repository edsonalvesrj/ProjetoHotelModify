/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hotel.dal;


import br.com.hotel.models.Servicos;
import br.com.hotel.models.Tarefa;
import br.com.hotel.util.HotelDB_util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author EDSON
 * 
 cod_tipo_servico serial NOT NULL,
  nome_tipo_servico character varying(200),
  descricao_tipo_servico character varying(200),
  data_cadastro date,
  CONSTRAINT "pkTiposervico" PRIMARY KEY (cod_tipo_servico)

 */
public class Tarefa_Dal {   
    
     
     private Connection connection;

    public Tarefa_Dal() {
        connection = HotelDB_util.getConnection();
    }  

    public void Add_tarefa(Tarefa modelo) {
         try {
             PreparedStatement prepare = 
             connection.prepareStatement("insert into tarefa (codservico,nometarefa,descricaotarefa,data_cadastro)values (?,?,?,NOW())");
             prepare.setInt(1, modelo.getServico().getCodigo());
             prepare.setString(2, modelo.getNome());
             prepare.setString(3,modelo.getDescricao());            
             prepare.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(Tarefa_Dal.class.getName()).log(Level.SEVERE, null, ex);
         }
     
    }

    public void Update_tarefa(Tarefa modelo) {
        try {
             PreparedStatement prepare = 
             connection.prepareStatement("update tarefa set nometarefa=?,descricaotarefa=?,data_cadastro = now() where codtarefa =?");
             prepare.setString(1, modelo.getNome());
             prepare.setString(2,modelo.getDescricao());                  
             prepare.setInt(3, modelo.getCodigo());
             prepare.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(Tarefa_Dal.class.getName()).log(Level.SEVERE, null, ex);
         }
     
    } 
    public void Delete_tarefa(int Id) {
         try {
             PreparedStatement prepare =
                     connection.prepareStatement("delete from tarefa where codservico =?");
             prepare.setInt(1, Id);
             prepare.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(Tarefa_Dal.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

     public void Deletee_tarefa(int Id) {
         try {
             PreparedStatement prepare =
                     connection.prepareStatement("delete from tarefa where codtarefa =?");
             prepare.setInt(1, Id);
             prepare.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(Tarefa_Dal.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    public Tarefa Pega_Tarefa(int id) { 
        Tarefa modelo = new Tarefa();
         try {
            
             PreparedStatement prepareded = connection.prepareStatement("select * from tarefa where codtarefa=?");
             prepareded.setInt(1,id);
             ResultSet rs = prepareded.executeQuery();                         
             if(rs.next()){
                 modelo.setCodigo(rs.getInt("codtarefa"));
                 modelo.setNome(rs.getString("nometarefa"));
                 modelo.setDescricao(rs.getString("descricaotarefa"));
                 modelo.setData(rs.getDate("data_cadastro"));
                 modelo.setServico(new Servicos());
                 modelo.getServico().setCodigo(rs.getInt("codservico"));
             }
             return modelo;
         } catch (SQLException ex) {
             Logger.getLogger(Tarefa_Dal.class.getName()).log(Level.SEVERE, null, ex);
         }
         return modelo;
    } 
    public List<Tarefa> ListaTodos() {
             List<Tarefa> lista = new ArrayList<Tarefa>();
         try {           
             
             Statement stm = connection.createStatement();
             ResultSet rs = stm.executeQuery("select * from tarefa ");
             while(rs.next()){
                 Tarefa modelo = new Tarefa();
                 modelo.setCodigo(rs.getInt("codtarefa"));
                 modelo.setNome(rs.getString("nometarefa"));
                 modelo.setDescricao(rs.getString("descricaotarefa"));
                 modelo.setData(rs.getDate("data_cadastro"));
                 lista.add(modelo); 
             }
           
         } catch (SQLException ex) {
             Logger.getLogger(Tarefa_Dal.class.getName()).log(Level.SEVERE, null, ex);
         } 
         return lista;
    }
     public List<Tarefa> ListaTodosRelacionados(int codigo) {
             List<Tarefa> lista = new ArrayList<Tarefa>();
         try {           
             PreparedStatement prepareded = connection.prepareStatement("select * from tarefa where codservico = ?");
             Statement stm = connection.createStatement();            
             prepareded.setInt(1, codigo);
             ResultSet rs = prepareded.executeQuery();    
             while(rs.next()){
                 Tarefa modelo = new Tarefa();
                 modelo.setCodigo(rs.getInt("codtarefa"));
                 modelo.setNome(rs.getString("nometarefa"));
                 modelo.setDescricao(rs.getString("descricaotarefa"));
                 modelo.setData(rs.getDate("data_cadastro"));
                 modelo.setServico(new Servicos());
                 modelo.getServico().setCodigo(rs.getInt("codservico"));
                 lista.add(modelo); 
             }
           
         } catch (SQLException ex) {
             Logger.getLogger(Tarefa_Dal.class.getName()).log(Level.SEVERE, null, ex);
         } 
         return lista;
    }

}
