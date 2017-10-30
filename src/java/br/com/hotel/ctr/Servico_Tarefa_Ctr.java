/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hotel.ctr;

import br.com.hotel.dal.Servico_Tarefa_Dal;
import br.com.hotel.dal.Servicos_Dal;
import br.com.hotel.dal.Tarefa_Dal;
import br.com.hotel.models.ServicoTarefa;
import br.com.hotel.models.Servicos;
import br.com.hotel.models.Tarefa;
import java.io.IOException;
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
public class Servico_Tarefa_Ctr extends HttpServlet {
    
    
    private static final long serialVersionUID = 1L;
    private static final String PAGINAPRINCIPAL = "/home.jsp";
    private static final String PAGINA_ADD_TIPOSERVICOS = "/cadtarefas.jsp";   
    private static final String PAGINASERVICOTAREFA = "/servicotarefa.jsp";
   
    private final Tarefa_Dal dao;
    private final Servicos_Dal daoS;
    private final Servico_Tarefa_Dal daoSs;
   
    public Servico_Tarefa_Ctr() {
        super();
        dao = new Tarefa_Dal();
        daoS=  new Servicos_Dal();
        daoSs = new Servico_Tarefa_Dal();
       
    }

    
    
    
     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String PAGINA = "";
       String acao = request.getParameter("action");
      
        if (acao.equalsIgnoreCase("delete")){
           
             int Id = Integer.parseInt(request.getParameter("codigo"));              
             dao.Delete_tarefa(Id);
             PAGINA = PAGINASERVICOTAREFA; 
             
             Servicos modelo = daoS.pegaServicoin(Id);
             request.setAttribute("servico", modelo); 
            // request.setAttribute("tarefar", dao.ListaTodosRelacionados());     
             request.setAttribute("tarefas", dao.ListaTodos()); 
             
        } else if (acao.equalsIgnoreCase("edit")){
             PAGINA = PAGINA_ADD_TIPOSERVICOS;
             int id = Integer.parseInt(request.getParameter("codigo"));
             Tarefa  model = dao.Pega_Tarefa(id);
             request.setAttribute("tarefa", model); 
             
             
        } 
        else if (acao.equalsIgnoreCase("servicotarefa")){
             PAGINA = PAGINASERVICOTAREFA;
             int id = Integer.parseInt(request.getParameter("codigo"));
            // request.setAttribute("tarefar", dao.ListaTodosRelacionados());          ;
             Servicos modelo = daoS.pegaServicoin(id);
             request.setAttribute("servico", modelo); 
              request.setAttribute("tarefas", dao.ListaTodos());
              
              
        }
        else if(acao.equalsIgnoreCase("cadtarefas")){
             PAGINA = PAGINA_ADD_TIPOSERVICOS;
        }
        
        else {
            PAGINA = PAGINAPRINCIPAL;
        }
        

        RequestDispatcher view = request.getRequestDispatcher(PAGINA);
        view.forward(request, response);
    }

     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
         
           ServicoTarefa modelo = new ServicoTarefa();
            modelo.setCodigoservico(Integer.parseInt(request.getParameter("nome")));           
            modelo.setCoigotarefa(Integer.parseInt(request.getParameter("descricao")));            
            String id = request.getParameter("codigo");
         if (id == null || id.isEmpty()) {
             daoSs.Add_Servicotarefa(modelo);
         }
         RequestDispatcher view = request.getRequestDispatcher(PAGINASERVICOTAREFA);
         request.setAttribute("tarefas", dao.ListaTodos());
         request.setAttribute("servicos", daoS.ListaTodos());

         view.forward(request, response);
         
     }
    
}
