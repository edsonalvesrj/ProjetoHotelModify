/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hotel.dal;


import br.com.hotel.models.ServicoTarefa;
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
 codservicotarefa serial NOT NULL,
  codtarefa integer,
  codservico integer
)

 */
public class Servico_Tarefa_Dal {   
    
     
     private Connection connection;

    public Servico_Tarefa_Dal() {
        connection = HotelDB_util.getConnection();
    }  

    public void Add_Servicotarefa(ServicoTarefa modelo) {
         try {
             PreparedStatement prepare = 
             connection.prepareStatement("insert into servicotarefa (codtarefa,codservico)values (?,?)");
             prepare.setInt(1, modelo.getCodigoservico());
             prepare.setInt(2,modelo.getCoigotarefa());            
             prepare.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(Servico_Tarefa_Dal.class.getName()).log(Level.SEVERE, null, ex);
         }
     
    }

    
    public void Delete_Servicotarefa(int Id) {
         try {
             PreparedStatement prepare =
                     connection.prepareStatement("delete from servicotarefa where codservicotarefa =?");
             prepare.setInt(1, Id);
             prepare.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(Servico_Tarefa_Dal.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    public Tarefa Pega_ServicoTarefa(int id) { 
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
             }
             return modelo;
         } catch (SQLException ex) {
             Logger.getLogger(Servico_Tarefa_Dal.class.getName()).log(Level.SEVERE, null, ex);
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
             Logger.getLogger(Servico_Tarefa_Dal.class.getName()).log(Level.SEVERE, null, ex);
         } 
         return lista;
    }
     

}
