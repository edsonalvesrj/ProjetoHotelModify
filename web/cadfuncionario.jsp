<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <script src="js/jquery.js" type="text/javascript"></script>
        <script src='http://code.jquery.com/jquery-2.1.3.min.js'></script>
        <script src="resources/btst/dist/js/bootstrap.js" type="text/javascript"></script>        
        <link href="resources/btst/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>       
        <link href="resources/css/estilo.css" rel="stylesheet" type="text/css"/>
        <link href="resources/dist/css/bootstrapValidator.css" rel="stylesheet" type="text/css"/>
        <script src="resources/dist/js/bootstrapValidator.js" type="text/javascript"></script>
        <script src="resources/dist/js/ValidarFormato.js" type="text/javascript"></script>
        <script src="resources/dist/js/validator.min.js" type="text/javascript"></script>
        <title>Adicionando funcionarios</title>
    </head>
    <body>
        <%@ include file = "menu.jsp" %>
        <div>
            <div  class="container">
                <div >
                    <label  class="center-block  text-center" for="#">Formulario de Funcionarios</label>

                </div>
                <div  class="col-md-7 cadastro">
                    <form id="cpf_form" method="POST"  action='Funcionario_Ctr' class="container-fluid center-block ">
                        <div class="form-group">
                            <label>Id</label>
                            <input type="text" class="form-control"  readonly="readonly" placeholder="Identificador"
                                   name="codigo" value="<c:out value="${funcionario.codigo}" />" />

                        </div>
                        <div class="form-group has-feedback">
                            <label>Nome</label>
                            <input type="text" class="form-control" name="nome" placeholder="Nome"
                                   required  value="<c:out value="${funcionario.nome}" />"/>
                        </div>
                        <div class="form-group has-feedback">
                            <label>Rg</label>
                            <input type="number" class="form-control" name="rg" placeholder="Rg"
                                   required   value="<c:out value="${funcionario.rg}" />"/>
                        </div>
                        <div class="form-group ">
                            <label>Cpf</label>

                            <input type="text" class="form-control" name="cpf" placeholder="Cpf" 
                                   maxlength="14" onkeypress=" return formatar('###.###.###-##', this); "
                                   required   value="<c:out value="${funcionario.cpf}" />"/>
                        </div>
                        <div class="form-group has-feedback">
                            <label>Tipo Funcionario</label>
                            <input type="text" class="form-control" name="tipo" placeholder="Tipo de Funcionario"
                                   required   value="<c:out value="${funcionario.tipo}" />"/>
                        </div>
                        <div class="form-group has-feedback">
                            <label>Data nascimento</label>
                            <input type="date" class="form-control" name="data" placeholder="data nascimento"
                                   required   value="<c:out value="${funcionario.data}" />"/>
                        </div>
                        <div class="form-group has-feedback">
                            <label>Endereço</label>
                            <input type="text" class="form-control" name="endereco" placeholder="Endereço"
                                   required  value="<c:out value="${funcionario.endereco}" />"/>
                        </div>  

                        <button type="submit" class="btn btn-primary">Enviar</button>
                         </form>
                </div>
            </div>        
    </div><!-- /.container-fluid -->
   
    <script>
        
$(document).ready(function() {
   
    $('#cpf_form').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            cpf: {
                validators: {
                    callback: {
                        message: 'Preencha Corretamente ',
                        callback: function(value) {
				return validacpf(value);
                            }
                   }
                }
           }
        }
    });
});
</script>
    <footer class="footer">
        <div class="container">
            <p  class="text-center "  ><a>Hoteis Arj :  Sua casa fora de casa  </a>  </p>
        </div>
    </footer>
</body>
</html>


