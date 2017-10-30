<%-- 
    Document   : homer
    Created on : 19/09/2017, 16:42:03
    Author     : EDSON
--%>

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

        <title>home</title>
    </head>
    <body>       
       <%@ include file = "menu.jsp" %>
        <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
                <li data-target="#myCarousel" data-slide-to="3"></li>
                <li data-target="#myCarousel" data-slide-to="4"></li>
            </ol>

            <!-- Wrapper for slides -->
            <div class="carousel-inner">
                <div class="item active">
                    <img id="image"src="resources/images/home.jpg" >
                </div>

                <div class="item">
                    <img id="image" src="resources/images/img-index.jpg" >
                </div>

                <div class="item">
                    <img id="image" src="resources/images/piscina.jpg"  >
                </div>
                <div class="item">
                    <img id="image" src="resources/images/quarto.jpg"  >
                </div>
                <div class="item">
                    <img  id="image" src="resources/images/quartoluxo.jpg" >
                </div>
            </div>

            <!-- Left and right controls -->
            <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left"></span>
                <span class="sr-only">Anterior</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right"></span>
                <span class="sr-only">Proximo</span>
            </a>
        </div>

        <footer id="footer">
            <div class="container">
                <p  class="text-center "  ><a>Hoteis Arj :  Sua casa fora de casa  </a>  </p>
            </div>
        </footer>
    </body>
</html>
