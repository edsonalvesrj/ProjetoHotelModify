<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <script src='http://code.jquery.com/jquery-2.1.3.min.js'></script>
        <script src="resources/btst/dist/js/bootstrap.js" type="text/javascript"></script>        
        <script src="js/jquery.js" type="text/javascript"></script>
        <link href="resources/btst/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>       
        <link href="resources/css/estilo.css" rel="stylesheet" type="text/css"/>
         <link href="resources/BootstrapSelect/dist/css/bootstrap-select.min.css" rel="stylesheet" type="text/css"/>
        <script src="resources/BootstrapSelect/dist/js/bootstrap-select.min.js" type="text/javascript"></script>
        <script src="resources/BootstrapSelect/dist/js/i18n/defaults-*.min.js" type="text/javascript"></script>
        <title> Serviço/Tarefas</title>
    </head>
    <body>
         <%@ include file = "menu.jsp" %>
        <div  class="container">
            <p><h2 class="text-center " >Serviço  </h2>  </p>
    </div>
      
    <div  class="container">
        <div >

            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Cod</th>
                        <th>Nome</th>                       
                        <th>Status</th>
                        <th>Cod Funcionario</th>
                        <th>Data</th>                     
                    </tr>
                </thead>               
                <tbody>                         
                        <tr>                             
                            <td><c:out value="${servico.codigo}" /></td>                           
                            <td><c:out value="${servico.nome}" /></td>                          
                            <td><c:out value="${servico.status}" /></td>
                            <td><c:out value="${servico.funcionario.codigo}" /></td>
                            <td><fmt:formatDate pattern="dd/MM/yyyy" value="${servico.dataHotario}" /></td>                                           
                            
                        </tr>
                   
                </tbody>
            </table>
        </div>
    </div><!-- /.container-fluid -->   
     <div  class="container">
            <p><h2 class="text-center " >Lista de Tarefas Cadastradas  </h2>  </p>
    </div>
    <div  class="container">
        <div >

            <table class="table table-striped">
                <thead>
                    <tr>
                        
                        <th>Nome</th>
                        <th>Descriçao</th>                                              
                        <th>Data de Criação</th>                        
                        <th>Exclusão</th>
                    </tr>
                </thead>
               
                <tbody>
                    <c:forEach items="${tarefar}" var="tiposerv">
                        <tr>                                  
                            
                            <td><c:out value="${tiposerv.nome}" /></td>
                            <td><c:out value="${tiposerv.descricao}" /></td>                           
                            <td><fmt:formatDate pattern="dd/MM/yyyy" value="${tiposerv.data}" /></td>                                 
                            <td><a class="btn btn-group btn-warning" href="Tarefa_Ctr?action=delete&codigo=<c:out value="${tiposerv.codigo}"/>">Remover</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div   
            <p><a  id="buton"class="btn btn-primary btn-block " href="Tarefa_Ctr?action=cadtarefas&codigo=<c:out value="${servico.codigo}" />">Adicionar Nova Tarefa  </a></p> 
           
                        </div>
    </div><!-- /.container-fluid --> 
   
    <div> 
  

    </div>            
    <footer class="footer">
        <div class="container">
            <p  class="text-center "  ><a href="home.jsp">Hoteis Arj :  Sua casa fora de casa  </a>  </p>
        </div>
    </footer>
</body>
</html>


