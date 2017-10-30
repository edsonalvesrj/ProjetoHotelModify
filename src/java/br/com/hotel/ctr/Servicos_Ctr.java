/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hotel.ctr;

import br.com.hotel.dal.Funcionario_Dal;
import br.com.hotel.dal.Servicos_Dal;
import br.com.hotel.dal.Tarefa_Dal;
import br.com.hotel.models.Funcionario;
import br.com.hotel.models.Servicos;
import br.com.hotel.models.Tarefa;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author EDSON
 */
public class Servicos_Ctr extends HttpServlet {
    
    
    private static final long serialVersionUID = 1L;
    private static final String PAGINAPRINCIPAL = "/home.jsp";
    private static final String PAGINA_ADD_SERVIÇOS = "/cadservicos.jsp";   
    private static final String PAGINALISTSERVICOS = "/listagemservicos.jsp";
   
    private final Servicos_Dal dao;

    public Servicos_Ctr() {
        super();
        dao = new Servicos_Dal();
    }

    
    
    
     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String PAGINA = "";
       String acao = request.getParameter("action");
      
        if (acao.equalsIgnoreCase("delete")){
            int Id = Integer.parseInt(request.getParameter("codigo"));
            dao.delete_Servico(Id);
            PAGINA = PAGINALISTSERVICOS;
            request.setAttribute("servicos", dao.ListaTodos());
            new Tarefa_Dal().Delete_tarefa(Id);
        } else if (acao.equalsIgnoreCase("edit")){
            
             PAGINA = PAGINA_ADD_SERVIÇOS;
             int id = Integer.parseInt(request.getParameter("codigo"));
             Servicos  model = dao.pegaServicoin(id);
             request.setAttribute("servico", model); 
             request.setAttribute("funcionarios", new Funcionario_Dal().ListaTodos());
        } 
        else if (acao.equalsIgnoreCase("listagemservicos")){
             PAGINA = PAGINALISTSERVICOS;
             request.setAttribute("servicos", dao.ListaTodos());
             
        }
        else if(acao.equalsIgnoreCase("cadservicos")){
             PAGINA = PAGINA_ADD_SERVIÇOS;
             request.setAttribute("funcionarios", new Funcionario_Dal().ListaTodos());
            
        }
        
        else {
            PAGINA = PAGINAPRINCIPAL;
        }
        

        RequestDispatcher view = request.getRequestDispatcher(PAGINA);
        view.forward(request, response);
    }

     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
           
            Servicos modelo = new Servicos();
            modelo.setFuncionario(new Funcionario());      
            modelo.setNome(request.getParameter("nome"));            
            modelo.getFuncionario().setCodigo(Integer.parseInt(request.getParameter("codfuncionario")));           
            try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data"));
            modelo.setDataHotario(date);
        } catch (ParseException e) {
            e.printStackTrace();
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
             dao.add_Servico(modelo);
         } else {
             modelo.setCodigo(Integer.parseInt(id));
             dao.update_Servico(modelo);
         }
         RequestDispatcher view = request.getRequestDispatcher(PAGINALISTSERVICOS);
         request.setAttribute("servicos", dao.ListaTodos());

         view.forward(request, response);
         
     }
    
}
