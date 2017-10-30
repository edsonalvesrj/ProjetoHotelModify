<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <script src='http://code.jquery.com/jquery-2.1.3.min.js'></script>
        <script src="resources/btst/dist/js/bootstrap.js" type="text/javascript"></script>        
        <link href="resources/btst/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>       
        <link href="resources/css/estilo.css" rel="stylesheet" type="text/css"/>
        <script src="resources/dist/js/validator.min.js" type="text/javascript"></script>
        <title>Adicionando Tarefas </title>
    </head>
    <body>
        <%@ include file = "menu.jsp" %>
        <div>
            <div  class="container">
                <div >
                    <label  class="center-block  text-center" for="#">Formulario de Tarefas </label>

                </div>
                <div  class="col-md-6 cadastro">
                    <form id="formulario" method="POST" action='Tarefa_Ctr' data-toggle="validator" class="container-fluid center-block ">
                       
                         <div class="form-group "><label>Identificador de Serviço</label>
                            <input type="number" class="form-control"  readonly="readonly" name="codigo" placeholder="Identificador Serviço"
                                   value="<c:out value="${tarefa.servico.codigo}" />"/>
                        </div>

                        <div class="form-group has-feedback"><label>Nome</label>
                            <input type="text" class="form-control" name="nome"
                                     required value="<c:out value="${tarefa.nome}" />"/>
                        </div>

                        <div class="form-group has-feedback"><label>Descrição</label>                      
                            <textarea  class="form-control" rows="5" name="descricao" 
                                  required     >${tarefa.descricao}</textarea>
                        </div>                     
                       
                        <button type="submit" class="btn btn-primary">Enviar</button>
                    </form>
                </div>
            </div>         


        </div>
    </div><!-- /.container-fluid -->

    <footer class="footer">
        <div class="container">
            <p class="text-center "  ><a href="home.jsp">Hoteis Arj :  Sua casa fora de casa  </a>  </p>
        </div>
    </footer>
</body>
</html>


