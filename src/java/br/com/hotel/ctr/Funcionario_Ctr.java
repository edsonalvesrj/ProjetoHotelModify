/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hotel.ctr;

import br.com.hotel.dal.Funcionario_Dal;
import br.com.hotel.models.Funcionario;
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
public class Funcionario_Ctr extends HttpServlet {
    
    
    private static final long serialVersionUID = 1L;
    private static final String PAGINAPRINCIPAL = "/home.jsp"; 
    private static final String PAGINA_ADD_FUNCIONARIO = "/cadfuncionario.jsp";
       private static final String PAGINALISTFUNCIONARIO ="listagemfuncionario.jsp";
    private final Funcionario_Dal dao;

    public Funcionario_Ctr() {
        super();
        dao = new Funcionario_Dal();
    }

    
    
    
    @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String PAGINA = "";
       String acao = request.getParameter("action");
       
        if (acao.equalsIgnoreCase("delete")){
            int Id = Integer.parseInt(request.getParameter("codigo"));
             dao.delete_Funcionario(Id);
             PAGINA = PAGINALISTFUNCIONARIO;
             request.setAttribute("funcionarios", dao.ListaTodos());    
        } else if (acao.equalsIgnoreCase("edit")){
             PAGINA = PAGINA_ADD_FUNCIONARIO;
             int id = Integer.parseInt(request.getParameter("codigo"));
             Funcionario model = dao.pegaFuncionario(id);
             request.setAttribute("funcionario", model);                    
        }
        else if (acao.equalsIgnoreCase("listagemfuncionario")){
            PAGINA = PAGINALISTFUNCIONARIO;
            request.setAttribute("funcionarios",dao.ListaTodos());         
        }
        else if(acao.equalsIgnoreCase("cadfuncionario")){
            PAGINA = PAGINA_ADD_FUNCIONARIO;
        }
        else{
            PAGINA = PAGINAPRINCIPAL;
          
        }            
       
        RequestDispatcher view = request.getRequestDispatcher(PAGINA);
        view.forward(request, response);
    }

    @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
         Funcionario modelo = new Funcionario();
         modelo.setNome(request.getParameter("nome"));
         modelo.setRg(request.getParameter("rg"));
         modelo.setCpf(request.getParameter("cpf"));
         modelo.setEndereco(request.getParameter("endereco"));
         modelo.setTipo(request.getParameter("tipo"));
         try {
             Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data"));
             modelo.setData(date);
         } catch (ParseException e) {
             e.printStackTrace();
         }

         String id = request.getParameter("codigo");
        if (id == null || id.isEmpty()) {
             dao.add_Funcionario(modelo);
        } else {
             modelo.setCodigo(Integer.parseInt(id));
             dao.update_Funcionario(modelo);
        }
        RequestDispatcher view = request.getRequestDispatcher(PAGINALISTFUNCIONARIO);
        request.setAttribute("funcionarios", dao.ListaTodos());

        view.forward(request, response);
    }

}
