/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hotel.dal;

import br.com.hotel.models.Funcionario;
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
 * fun_cod serial NOT NULL,
  fun_nome character varying(100),
  fun_rg character varying(50),
  fun_end character varying(200),
  fun_cpf character varying(50),
  fun_tipo character varying(50),
  CONSTRAINT pk_fun PRIMARY KEY (fun_cod)
 */
public class Funcionario_Dal {

    
     private Connection connection;

    public Funcionario_Dal() {
        connection = HotelDB_util.getConnection();
    }
    
    
      public void add_Funcionario(Funcionario modelo) {
      
         try {
             PreparedStatement prepare = connection.prepareStatement("insert into funcionario (fun_nome,fun_rg,fun_cpf,"
                     + "fun_end,fun_tipo,fun_data) values (?,?,?,?,?,?)");
             prepare.setString(1, modelo.getNome());
              prepare.setString(2, modelo.getRg());
               prepare.setString(3, modelo.getCpf());
                prepare.setString(4, modelo.getEndereco());
                 prepare.setString(5, modelo.getTipo());
                  prepare.setDate(6, new java.sql.Date(modelo.getData().getTime()));
                  prepare.executeUpdate();
         } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null,"erro insert"+ex.getMessage());           
            ex.printStackTrace();
             Logger.getLogger(Funcionario_Dal.class.getName()).log(Level.SEVERE, null, ex);
         }
          
    }

    public void update_Funcionario(Funcionario modelo) {
         try {
             PreparedStatement prepare = connection.prepareStatement("update funcionario set fun_nome =?, fun_rg =?, fun_cpf=?,"
                     + "fun_end=?,fun_tipo=?,fun_data=? where fun_cod =? ");
                prepare.setString(1, modelo.getNome());
                prepare.setString(2, modelo.getRg());
                prepare.setString(3, modelo.getCpf());
                prepare.setString(4,modelo.getEndereco());
                prepare.setString(5, modelo.getTipo());
                prepare.setDate(6,  new java.sql.Date(modelo.getData().getTime()));
                prepare.setInt(7,modelo.getCodigo());
                prepare.executeUpdate();
             
         } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null,"erro update"+ex.getMessage());           
               ex.printStackTrace();
             Logger.getLogger(Funcionario_Dal.class.getName()).log(Level.SEVERE, null, ex);
         }     
    }    

    public void delete_Funcionario(int Id) {
        try {
            PreparedStatement prepared = connection.prepareStatement("delete from funcionario where fun_cod=?");
            prepared.setInt(1, Id);
            prepared.executeUpdate();
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"erro delete"+ex.getMessage());           
            ex.printStackTrace();
            Logger.getLogger(Funcionario_Dal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Funcionario pegaFuncionario(int id) {
           Funcionario  modelo = new Funcionario();
         try {
             PreparedStatement prepare = connection.prepareStatement(" select * from  funcionario  where fun_cod =?");
             prepare.setInt(1,id);
              ResultSet rs = prepare.executeQuery();
               if(rs.next()){            
                 modelo.setCodigo(rs.getInt("fun_cod"));
                 modelo.setNome(rs.getString("fun_nome"));
                 modelo.setRg(rs.getString("fun_rg"));
                 modelo.setCpf(rs.getString("fun_cpf"));                
                 modelo.setEndereco(rs.getString("fun_end"));
                 modelo.setData(rs.getDate("fun_data"));
                 modelo.setTipo(rs.getString("fun_tipo"));
               
            }
         } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null,"erro select "+ex.getMessage());           
              ex.printStackTrace();
             Logger.getLogger(Funcionario_Dal.class.getName()).log(Level.SEVERE, null, ex);
         }
        return modelo;
    }

   public List<Funcionario> ListaTodos() {
        
       List<Funcionario> lista = new ArrayList<Funcionario>();
       
         Statement stm;
         try {
             stm = connection.createStatement();
             ResultSet rs = stm.executeQuery("select * from funcionario ");
          
               while(rs.next()){
                 Funcionario modelo = new Funcionario();
                 modelo.setCodigo(rs.getInt("fun_cod"));
                 modelo.setNome(rs.getString("fun_nome"));
                 modelo.setRg(rs.getString("fun_rg"));
                 modelo.setCpf(rs.getString("fun_cpf"));                
                 modelo.setEndereco(rs.getString("fun_end"));
                 modelo.setData(rs.getDate("fun_data"));
                 modelo.setTipo(rs.getString("fun_tipo")); 
                 lista.add(modelo);
               }
         } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null,"erro selectall "+ex.getMessage());           
              ex.printStackTrace();
               Logger.getLogger(Funcionario_Dal.class.getName()).log(Level.SEVERE, null, ex);
         } 
        
       return lista;
    }
    
}
