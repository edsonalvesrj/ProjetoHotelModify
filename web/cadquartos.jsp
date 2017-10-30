<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <script src='http://code.jquery.com/jquery-2.1.3.min.js'></script>
        <script src="resources/btst/dist/js/bootstrap.js" type="text/javascript"></script>       
        <script src="js/bootstrapValidator.js" type="text/javascript"></script>
        <script src="js/bootstrapValidator.min.js" type="text/javascript"></script>
        <script src="js/jquery.js" type="text/javascript"></script>
        <link href="resources/btst/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>       
        <link href="resources/css/estilo.css" rel="stylesheet" type="text/css"/>
        <script src="resources/dist/js/validator.min.js" type="text/javascript"></script>
        <title>Adicionando quartos</title>
    </head>
    <body>
         <%@ include file = "menu.jsp" %>
        <div>
            <div  class="container">
                <div >
                    <label  class="center-block  text-center" for="#">Formulario de Quartos</label>

                </div>
                <div  class="col-md-6 cadastro">
                    <form id="formulario" method="POST" action='Quartos_Ctr' data-toggle="validator"  class="container-fluid center-block ">
                        <div class="form-group"><label>Id</label>
                            <input type="number" class="form-control"  readonly="readonly" name="codigo" placeholder="Identificador"
                                    value="<c:out value="${quarto.codigo}" />"/>
                        </div>

                        <div class="form-group has-success"><label>Nome</label>
                            <input type="text" class="form-control" name="nome" id="inputName" placeholder="nome"
                               required   required   value="<c:out value="${quarto.nome}" />"/>
                             
                        </div>

                        <div class="form-group has-feedback "><label>Descrição</label>                      
                            <textarea  class="form-control input-group " rows="5" name="descricao"  placeholder="descrição" 
                                     required >${quarto.descricao}</textarea>
                                  
                        </div>

                        <div class="form-group has-feedback"><label >Data</label>
                            <input type="date" class="form-control" name="data" placeholder="data"
                                 required   value="<c:out value="${quarto.data}" />"/>
                        </div>                     
                                  
                        <c:if test="${quarto.status eq null}">
                           <div class="form-check has-feedback radio"><label class="form-check-label">
                                <input class="form-check-input" type="radio" name="status"  
                                 required  value="<c:out value="a" />"/> Quarto Ativado</label>
                               
                           </div>
                           <div class="form-check has-feedback radio"><label class="form-check-label">
                                <input class="form-check-input" type="radio"  name="status" 
                                    required  value="<c:out value="d" />"/> Quarto Desativado</label>
                                  
                          </div>
                        </c:if>
                         <c:if test="${quarto.status eq false}">
                           <div class="form-check has-feedback radio"><label class="form-check-label">
                                <input class="form-check-input" type="radio" name="status"  
                                  required value="<c:out value="a" />"/> Quarto Ativado</label>
                                
                           </div>
                           <div class="form-check radio"><label class="form-check-label">
                                   <input class="form-check-input" type="radio"  name="status"  checked="true"
                                  required   value="<c:out value="d" />"/> Quarto Desativado</label>
                                  
                          </div>
                        </c:if>
                         <c:if test="${quarto.status eq true}">
                           <div class="form-check radio"><label class="form-check-label">
                                <input class="form-check-input" type="radio" name="status"  checked="true"
                                required   value="<c:out value="a" />"/>Quarto Ativado</label>
                               
                           </div>
                           <div class="form-check  radio"><label class="form-check-label">
                                   <input class="form-check-input" type="radio"  name="status" 
                                 required    value="<c:out value="d" />"/>Quarto Desativado</label>
                               
                          </div>
                        </c:if>
                        <button type="submit" class="btn btn-primary">Enviar</button>
                    </form>
                </div>
            </div>         


        </div>
    </div><!-- /.container-fluid -->

    <footer class="footer">
        <div class="container">
            <p class="text-center "  ><a href="home.jsp" > Hoteis Arj :  Sua casa fora de casa  </a>  </p>
        </div>
    </footer>
</body>
</html>


