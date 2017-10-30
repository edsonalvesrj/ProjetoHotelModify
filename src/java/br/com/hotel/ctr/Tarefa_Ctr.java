/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hotel.ctr;

import br.com.hotel.dal.Servicos_Dal;
import br.com.hotel.dal.Tarefa_Dal;
import br.com.hotel.models.Servicos;
import br.com.hotel.models.Tarefa;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
public class Tarefa_Ctr extends HttpServlet {
    
    
    private static final long serialVersionUID = 1L;
    private static final String PAGINAPRINCIPAL = "/home.jsp";
    private static final String PAGINA_ADD_TIPOSERVICOS = "/cadtarefas.jsp";   
    private static final String PAGINASERVICOTAREFA = "/servicotarefa.jsp";
    private static final String PAGINALISTAGEMTAREFAS = "/listagemtarefas.jsp";
   
    private final Tarefa_Dal dao;
    private final Servicos_Dal daoS;
    public Tarefa_Ctr() {
        super();
        dao = new Tarefa_Dal();
         daoS=  new Servicos_Dal();
    }

    
    
    
     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String PAGINA = "";
       String acao = request.getParameter("action");
      
        if (acao.equalsIgnoreCase("delete")){
            
            int Id = Integer.parseInt(request.getParameter("codigo"));
            Tarefa tarefa = dao.Pega_Tarefa(Id);           
            Servicos servico = new Servicos_Dal().pegaServico(tarefa.getServico().getCodigo());                  
            dao.Deletee_tarefa(Id);
            PAGINA = PAGINASERVICOTAREFA;          
            request.setAttribute("tarefar",dao.ListaTodosRelacionados(servico.getCodigo()));
            request.setAttribute("servico",servico );
            
        } else if (acao.equalsIgnoreCase("servicotarefa")){
            
            int Id = Integer.parseInt(request.getParameter("codigo"));                       
            Servicos servico = new Servicos_Dal().pegaServico(Id);      
            PAGINA = PAGINASERVICOTAREFA;          
            request.setAttribute("tarefar",dao.ListaTodosRelacionados(Id));
            request.setAttribute("servico",servico );
            
        }else if (acao.equalsIgnoreCase("edit")){
            
             PAGINA = PAGINA_ADD_TIPOSERVICOS;
             int id = Integer.parseInt(request.getParameter("codigo"));
             Tarefa  model = dao.Pega_Tarefa(id);
             request.setAttribute("tarefa", model);                   
        } 
        else if (acao.equalsIgnoreCase("listagemtarefas")){
            
             PAGINA = PAGINALISTAGEMTAREFAS;
             request.setAttribute("tarefas", dao.ListaTodos());
        }
        else if(acao.equalsIgnoreCase("cadtarefas")){
            
             PAGINA = PAGINA_ADD_TIPOSERVICOS;
             int id = Integer.parseInt(request.getParameter("codigo"));
             Tarefa tarefa = new Tarefa();
             tarefa.setServico(new Servicos());
             tarefa.getServico().setCodigo(id);
             request.setAttribute("tarefa", tarefa);
           
        }
        
        else {
            PAGINA = PAGINAPRINCIPAL;
        }
        

        RequestDispatcher view = request.getRequestDispatcher(PAGINA);
        view.forward(request, response);
    }

     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
         
            Tarefa modelo = new Tarefa();
            Integer id = Integer.parseInt(request.getParameter("codigo"));
            modelo.setNome(request.getParameter("nome"));           
            modelo.setDescricao(request.getParameter("descricao")); 
            modelo.setServico(new Servicos());
            modelo.getServico().setCodigo(id);
          
             dao.Add_tarefa(modelo);
       
         RequestDispatcher view = request.getRequestDispatcher(PAGINASERVICOTAREFA);
         request.setAttribute("tarefar", dao.ListaTodosRelacionados(id));
         request.setAttribute("servico", new Servicos_Dal().pegaServicoin(id)); 
         view.forward(request, response);
         
     }
    
}
