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
        <title>Lista de quartos </title>
    </head>
    <body>
         <%@ include file = "menu.jsp" %>
        <div  class="container">
            <p><h2 class="text-center " >Lista de Quartos Cadastrados  </h2>  </p>
    </div>
    <div  class="container">
        <div >

            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Cod</th>
                        <th>Nome</th>
                        <th>Descriçao</th>
                        <th>Status</th>                               
                        <th>Data de Criação</th>
                        <th>Alterações</th>
                        <th>Exclusão</th>
                    </tr>
                </thead>
               
                <tbody>
                    <c:forEach items="${quartos}" var="quart">
                        <tr>                                    
                            <td><c:out value="${quart.codigo}" /></td>
                            <td><c:out value="${quart.nome}" /></td>
                            <td><c:out value="${quart.descricao}" /></td>
                            <td><c:out value="${quart.status}" /></td>
                            <td><fmt:formatDate pattern="dd/MM/yyyy" value="${quart.data}" /></td>                                                          
                            <td><a class="btn btn-group btn-primary" href="Quartos_Ctr?action=edit&codigo=<c:out value="${quart.codigo}"/>">Alterar</a></td>
                            <td><a class="btn btn-group btn-warning" href="Quartos_Ctr?action=delete&codigo=<c:out value="${quart.codigo}"/>">Excluir</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div><!-- /.container-fluid -->           
    <div> 
        <p><a  id="buton"class="btn btn-primary btn-block " href="cadquartos.jsp">Adicionar Novo Quarto </a></p>         

    </div>            
    <footer class="footer">
        <div class="container">
            <p  class="text-center "  ><a href="home.jsp">Hoteis Arj :  Sua casa fora de casa  </a>  </p>
        </div>
    </footer>
</body>
</html>


