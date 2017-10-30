/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hotel.ctr;

import br.com.hotel.dal.Funcionario_Dal;
import br.com.hotel.dal.Quartos_Dal;
import br.com.hotel.models.Funcionario;
import br.com.hotel.models.Quartos;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author EDSON
 */
public class Quartos_Ctr extends HttpServlet {
    
    
    private static final long serialVersionUID = 1L;
    private static final String PAGINAPRINCIPAL = "/home.jsp";   
    private static final String PAGINA_ADD_QUARTOS = "/cadquartos.jsp";  
    private static final String PAGINALISTQUARTOS ="listagemquartos.jsp";   
    private final Quartos_Dal dao;

    public Quartos_Ctr() {
        super();
        dao = new Quartos_Dal();
    }

    
    
    
     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String PAGINA = "";
       String acao = request.getParameter("action");
       
        if (acao.equalsIgnoreCase("delete")){
            int Id = Integer.parseInt(request.getParameter("codigo"));
            dao.delete_Quarto(Id);
            PAGINA = PAGINALISTQUARTOS;
            request.setAttribute("quartos", dao.ListaTodos());    
        } else if (acao.equalsIgnoreCase("edit")){
             PAGINA = PAGINA_ADD_QUARTOS;
             int id = Integer.parseInt(request.getParameter("codigo"));
             Quartos model = dao.pegaQuarto(id);
             request.setAttribute("quarto", model);                  
        } else if (acao.equalsIgnoreCase("listagemquartos")){
            PAGINA = PAGINALISTQUARTOS;
            request.setAttribute("quartos", dao.ListaTodos());    
        }
        else if(acao.equalsIgnoreCase("cadquartos")){
             PAGINA = PAGINA_ADD_QUARTOS;
        }
        else{
         PAGINA = PAGINAPRINCIPAL;   
        }

        RequestDispatcher view = request.getRequestDispatcher(PAGINA);
        view.forward(request, response);
    }

     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
          
            Quartos  modelo = new Quartos();
            modelo.setNome(request.getParameter("nome"));
            modelo.setDescricao(request.getParameter("descricao"));
            Date data = new Date();
            String parametro = request.getParameter("data");
            if(parametro !=null){
              try {        
                   data = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data"));
                   modelo.setData(data);
                } catch (ParseException ex) {
                    Logger.getLogger(Quartos_Ctr.class.getName()).log(Level.SEVERE, null, ex);
                }
              
            }else{
            modelo.setData(new Date());
            }
            boolean stats ;
            String status = request.getParameter("status");          
            if(status.equals("a")){
               stats = true;
            }
            else{
               stats = false;
            }
            modelo.setStatus(stats);
           
        
         String id = request.getParameter("codigo");
         if (id == null || id.isEmpty()) {
             dao.add_Quarto(modelo);
              
         } else {
             modelo.setCodigo(Integer.parseInt(id));
             dao.update_Quarto(modelo);
              
         }
         RequestDispatcher view = request.getRequestDispatcher(PAGINALISTQUARTOS);
         request.setAttribute("quartos", dao.ListaTodos());

         view.forward(request, response);
    
     }
}

