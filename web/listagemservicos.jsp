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
        <title>lista Serviços</title>
    </head>
    <body>
         <%@ include file = "menu.jsp" %>
        <div  class="container">
            <p><h2 class="text-center " >Lista de Serviços Cadastrados  </h2>  </p>
    </div>
    <div  class="container">
        <div >

            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Cod</th>
                        <th>Nome</th>                       
                        <th>Status</th>
                        <th>Data</th>
                        <th>Alterações</th>
                        <th>Exclusão</th>
                        <th> Tarefas  </th>
                    </tr>
                </thead>
               
                <tbody>
                    <c:forEach items="${servicos}" var="serv">
                        <tr>                                    
                            <td><c:out value="${serv.codigo}" /></td>
                            <td><c:out value="${serv.nome}" /></td>                          
                            <td><c:out value="${serv.status}" /></td>
                            <td><fmt:formatDate pattern="dd/MM/yyyy" value="${serv.dataHotario}" /></td>                                                          
                            <td><a class="btn btn-group btn-primary" href="Servicos_Ctr?action=edit&codigo=<c:out value="${serv.codigo}"/>">Alterar</a></td>
                            <td><a class="btn btn-group btn-warning" href="Servicos_Ctr?action=delete&codigo=<c:out value="${serv.codigo}"/>">Excluir</a></td>
                            <td><a class="btn btn-group btn-primary" href="Tarefa_Ctr?action=servicotarefa&codigo=<c:out value="${serv.codigo}"/>">Tarefas </a></td>
                             
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div><!-- /.container-fluid -->           
    <div> 
        <p><a  id="buton"class="btn btn-primary btn-block " href="Servicos_Ctr?action=cadservicos">Adicionar Novo Serviço </a></p>         

    </div>            
    <footer class="footer">
        <div class="container">
            <p  class="text-center "  ><a href="home.jsp">Hoteis Arj :  Sua casa fora de casa  </a>  </p>
        </div>
    </footer>
</body>
</html>


