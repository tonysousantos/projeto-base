<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>

<%@ include file="cabecalho.html" %>
			
      <div align="center">
        <h1>Programa��o para Internet</h1>
      </div>
      <br>
       <div>
          <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<center>
		<c:url value="/imagens/flf.png" var="imagem"> </c:url>
		<img alt="" src="${imagem}"/>
     </div>
      

      <footer class="footer">
      <br>
      <br>
      <br>
        <p align="right">&copy; ADS 2017.2 ANTONIO JOS� SOUSA DOS SANTOS 20716109</p>
      </footer>

    </div> <!-- /container -->
    
    <%@ include file="rodape.html" %>
