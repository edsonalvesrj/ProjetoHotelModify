/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hotel.dal;


import br.com.hotel.models.Funcionario;
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
import javax.swing.JOptionPane;

/**
 *
 * @author EDSON
 * 
 *serv_cod serial NOT NULL,
  sev_nome character varying(200),
  serv_desc character varying(200),
  serv_horario date,
  serv_status boolean,
 */
public class Servicos_Dal {   
    
     
     private Connection connection;

    public Servicos_Dal() {
        connection = HotelDB_util.getConnection();
    }  

    public void add_Servico(Servicos modelo) {
         try {
             
             PreparedStatement prepare = 
             connection.prepareStatement("insert into servicos (serv_nome,cod_funcionario,serv_horario,serv_status)values (?,?,?,?)");
             prepare.setString(1, modelo.getNome());
             prepare.setInt(2, modelo.getFuncionario().getCodigo());          
             prepare.setDate(3, new java.sql.Date(modelo.getDataHotario().getTime()));
             prepare.setBoolean(4, modelo.isStatus());
             prepare.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(Servicos_Dal.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null,ex.getMessage());
         }
     
    }

    public void update_Servico(Servicos modelo) {
        try {
             PreparedStatement prepare = 
             connection.prepareStatement("update servicos set serv_nome=?,cod_funcionario=? ,serv_horario=?,serv_status=? where serv_cod =?");
             prepare.setString(1, modelo.getNome());
             prepare.setInt(2, modelo.getFuncionario().getCodigo());            
             prepare.setDate(3, new java.sql.Date(modelo.getDataHotario().getTime()));
             prepare.setBoolean(4, modelo.isStatus());
             prepare.setInt(5, modelo.getCodigo());
             prepare.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(Servicos_Dal.class.getName()).log(Level.SEVERE, null, ex);
         }
     
    } 
    public void delete_Servico(int Id) {
         try {
             PreparedStatement prepare =
                     connection.prepareStatement("delete from servicos where serv_cod =?");
             prepare.setInt(1, Id);
             prepare.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(Servicos_Dal.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    public Servicos pegaServico(int id) { 
        Servicos modelo = new Servicos();
        
         try {           
             PreparedStatement prepareded = connection.prepareStatement("select * from servicos where serv_cod=?");
             prepareded.setInt(1,id);
             ResultSet rs = prepareded.executeQuery();                         
             if(rs.next()){
                 modelo.setFuncionario(new Funcionario());               
                 modelo.setCodigo(rs.getInt("serv_cod"));
                 modelo.setNome(rs.getString("serv_nome"));
                 modelo.getFuncionario().setCodigo(rs.getInt("cod_funcionario"));              
                 modelo.setDataHotario(rs.getDate("serv_horario"));
                 modelo.setStatus(rs.getBoolean("serv_status"));
             }
             return modelo;
         } catch (SQLException ex) {
             Logger.getLogger(Servicos_Dal.class.getName()).log(Level.SEVERE, null, ex);
         }
         return modelo;
    } 
    public List<Servicos> ListaTodos() {
             List<Servicos> lista = new ArrayList<Servicos>();
         try {           
             
             Statement stm = connection.createStatement();
             ResultSet rs = stm.executeQuery("select * from servicos ");
             while(rs.next()){
                 Servicos modelo = new Servicos();
                 modelo.setCodigo(rs.getInt("serv_cod"));
                 modelo.setNome(rs.getString("serv_nome"));
                 modelo.setFuncionario(new Funcionario_Dal().pegaFuncionario(rs.getInt("cod_funcionario")));               
                 modelo.setDataHotario(rs.getDate("serv_horario"));
                 modelo.setStatus(rs.getBoolean("serv_status"));
                 lista.add(modelo); 
             }
           
         } catch (SQLException ex) {
             Logger.getLogger(Servicos_Dal.class.getName()).log(Level.SEVERE, null, ex);
         } 
         return lista;
    }
    public Servicos pegaServicoin(int id) { 
        Servicos modelo = new Servicos();
         try {
            
             PreparedStatement prepareded = connection.prepareStatement("select * from servicos where serv_cod =? ");
             prepareded.setInt(1,id);
             ResultSet rs = prepareded.executeQuery();                         
             if(rs.next()){
                 modelo.setFuncionario(new Funcionario());             
                 modelo.setCodigo(rs.getInt("serv_cod"));
                 modelo.setNome(rs.getString("serv_nome"));
                 modelo.setFuncionario(new Funcionario_Dal().pegaFuncionario(rs.getInt("cod_funcionario")));                
                 modelo.setDataHotario(rs.getDate("serv_horario"));
                 modelo.setStatus(rs.getBoolean("serv_status"));
             }
             return modelo;
         } catch (SQLException ex) {
             Logger.getLogger(Servicos_Dal.class.getName()).log(Level.SEVERE, null, ex);
         }
         return modelo;
    } 

}
