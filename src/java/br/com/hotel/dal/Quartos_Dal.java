/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hotel.dal;


import br.com.hotel.models.Quartos;
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
 *quarto_cod integer NOT NULL DEFAULT nextval('quartos_quarto_codigo_seq'::regclass),
  quarto_nome character varying(150),
  quarto_desc character varying(200),
  quarto_data date,
  quarto_status boolean,
 */
public class Quartos_Dal {
    
    
     
     private Connection connection;

    public Quartos_Dal() {
        connection = HotelDB_util.getConnection();
    }
     
    public void add_Quarto(Quartos modelo) {
          
         try {
             PreparedStatement prepare = 
                     connection.prepareStatement("insert into quartos (quarto_nome,quarto_desc,quarto_data,quarto_status) "
                             + "values (?,?,?,?)");
             prepare.setString(1,modelo.getNome());
             prepare.setString(2, modelo.getDescricao());
             prepare.setDate(3, new java.sql.Date(modelo.getData().getTime()));
             prepare.setBoolean(4, modelo.isStatus());
             prepare.executeUpdate();
         } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null,"erro insert"+ex.getMessage());           
            ex.printStackTrace();
             Logger.getLogger(Quartos_Dal.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    public void update_Quarto(Quartos modelo) {
        try {
             PreparedStatement prepare = 
                     connection.prepareStatement("update quartos set quarto_nome=?,quarto_desc=?,quarto_data=?"
                             + ",quarto_status=?  where quarto_cod=?");
             prepare.setString(1,modelo.getNome());
             prepare.setString(2, modelo.getDescricao());
             prepare.setDate(3, new java.sql.Date(modelo.getData().getTime()));
             prepare.setBoolean(4, modelo.isStatus());
             prepare.setInt(5,modelo.getCodigo());
             prepare.executeUpdate();
         } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null,"erro update"+ex.getMessage());           
             ex.printStackTrace();
             Logger.getLogger(Quartos_Dal.class.getName()).log(Level.SEVERE, null, ex);
         }
    } 

    public void delete_Quarto(int Id) {       
         try { 
             PreparedStatement prepare =
                     connection.prepareStatement("delete from quartos where quarto_cod=?");
             prepare.setInt(1,Id);
             prepare.executeUpdate();
         } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null,"erro delete"+ex.getMessage());           
              ex.printStackTrace();
             Logger.getLogger(Quartos_Dal.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    public Quartos pegaQuarto(int id) {
        Quartos modelo = new Quartos();         
         try {
             PreparedStatement prepare =
                     connection.prepareStatement("select * from quartos where quarto_cod =?");  
             prepare.setInt(1, id);
             ResultSet rs = prepare.executeQuery();
               if(rs.next()){            
                    
                 modelo.setNome(rs.getString("quarto_nome"));
                 modelo.setDescricao(rs.getString("quarto_desc"));                
                 modelo.setData(rs.getDate("quarto_data"));
                 modelo.setStatus(rs.getBoolean("quarto_status")); 
                 modelo.setCodigo(rs.getInt("quarto_cod"));   
               
            }
         } catch (SQLException ex) {
                 
              ex.printStackTrace();
             Logger.getLogger(Quartos_Dal.class.getName()).log(Level.SEVERE, null, ex);
         }
        return modelo;
    }

   
    public List<Quartos> ListaTodos() {
          List<Quartos> lista = new ArrayList<Quartos>();
         try {
            
             Statement stm = connection.createStatement();
             ResultSet rs = stm.executeQuery("select * from quartos");
             while(rs.next()){
               Quartos modelo = new Quartos();
                 modelo.setCodigo(rs.getInt("quarto_cod"));
                 modelo.setNome(rs.getString("quarto_nome"));
                 modelo.setDescricao(rs.getString("quarto_desc"));                
                 modelo.setData(rs.getDate("quarto_data"));
                 modelo.setStatus(rs.getBoolean("quarto_status")); 
                 lista.add(modelo);
             }
             
             
         } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,ex.getMessage());
             Logger.getLogger(Quartos_Dal.class.getName()).log(Level.SEVERE, null, ex);
         }
         return lista;
    }
}
