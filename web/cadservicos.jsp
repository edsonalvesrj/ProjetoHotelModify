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
        <link href="resources/BootstrapSelect/dist/css/bootstrap-select.min.css" rel="stylesheet" type="text/css"/>
        <script src="resources/BootstrapSelect/dist/js/bootstrap-select.min.js" type="text/javascript"></script>
        <script src="resources/BootstrapSelect/dist/js/i18n/defaults-*.min.js" type="text/javascript"></script>
        <title>Adicionando Serviços</title>
    </head>
    <body>
        <%@ include file = "menu.jsp" %>
        <div>
            <div  class="container">
                <div >
                    <label  class="center-block  text-center" for="#">Formulario de serviços</label>

                </div>
                <div  class="col-md-6 cadastro">
                    <form id="formulario" method="POST" action='Servicos_Ctr' data-toggle="validator" class="container-fluid center-block ">
                        <div class="form-group "><label>Id</label>
                            <input type="number" class="form-control"  readonly="readonly" name="codigo" placeholder="Identificador"
                                   value="<c:out value="${servico.codigo}" />"/>
                        </div>

                        <div class="form-group has-feedback"><label>Nome</label>
                            <input type="text" class="form-control" name="nome"
                                     required value="<c:out value="${servico.nome}" />"/>
                        </div>                       
                        <div class="form-group has-feedback " ><label> Funcionario   </label>
                            <select class="selectpicker" name ="codfuncionario" >
                                <c:forEach items="${funcionarios}" var="funcionario">
                                    <option value="<c:out value="${funcionario.codigo}"/>" 
                                            ${funcionario.codigo == servico.funcionario.codigo ? 'selected' : ''}>
                                                   <c:out value="${funcionario.nome}"/>
                                    </option >
                                </c:forEach>
                            </select>
                            </div>
                        <div class="form-group has-feedback"><label >Data</label>
                            <input type="date" class="form-control" name="data" placeholder="data de execuçao do serviço"
                                  required  value="<c:out value="${servico.dataHotario}" />"/>
                        </div>
                        <c:if test="${servico.status eq null}">
                           <div class="form-check has-feedback"><label class="form-check-label">
                                <input class="form-check-input" type="radio" name="status"  
                                required  value="<c:out value="a" />"/> Serviço Ativado</label>
                           </div>
                           <div class="form-check"><label class="form-check-label">
                                <input class="form-check-input" type="radio"  name="status" 
                                 required    value="<c:out value="d" />"/> Serviço Desativado</label>
                          </div>
                        </c:if>
                         <c:if test="${servico.status eq false}">
                           <div class="form-check"><label class="form-check-label">
                                <input class="form-check-input" type="radio" name="status"  
                                required   value="<c:out value="a" />"/> Serviço Ativado</label>
                           </div>
                           <div class="form-check"><label class="form-check-label">
                                   <input class="form-check-input" type="radio"  name="status"  checked="true"
                                 required    value="<c:out value="d" />"/> Serviço Desativado</label>
                          </div>
                        </c:if>
                         <c:if test="${servico.status eq true}">
                           <div class="form-check"><label class="form-check-label">
                                <input class="form-check-input" type="radio" name="status"  checked="true"
                                required   value="<c:out value="a" />"/>Serviço Ativado</label>
                           </div>
                           <div class="form-check"><label class="form-check-label">
                                   <input class="form-check-input" type="radio"  name="status" 
                                required     value="<c:out value="d" />"/>Serviço Desativado</label>
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
            <p class="text-center "  ><a href="home.jsp">Hoteis Arj :  Sua casa fora de casa  </a>  </p>
        </div>
    </footer>
</body>
</html>


