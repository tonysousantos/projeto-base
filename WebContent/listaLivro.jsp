<%@ page language="java" import="java.sql.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ include file="cabecalho.html" %>

<%@ page import="java.util.Date" %>
<%@ page import="br.com.flf.jdbc.LivroDao" %>
<%@ page import="br.com.flf.models.Livro" %>
<%@ page import="java.util.List"  %>
<%@ page import="java.text.DateFormat"  %>
<%@ page import="java.text.SimpleDateFormat"  %>


<% DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); %>

<%
		LivroDao dao = new LivroDao();
		List<Livro> livros = dao.getLista();
%>
    <div class="page-header">
        <h1>Lista de Livros</h1>
    </div>

   <div class="row">
        <div class="col-sm-7 col-sm-offset-5 col-md-12 col-md-offset-0 main">
                     
                <a href="adicionaLivro.jsp">
                   <button class="btn btn-primary pull-right" data-toggle="tooltip" title="Novo">
                        <span class="glyphicon glyphicon-log-in" aria-hidden="true" ></span>
                    </button> </a>
                
                <a href="pesquisaLivro.jsp">
                   <button class="btn btn-default pull-right" data-toggle="tooltip" title="Pesquisar">
                        <span class="glyphicon glyphicon-search" aria-hidden="true" ></span>
                    </button> </a>

        </div>
    </div>

        <div class="row ">
        	<div class="col-md-12">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>Titulo</th>
                  <th>Autores</th>
                  <th>Gênero</th>
                  <th>Ano</th>
                  <th>Editora</th>
                  <th>Ação</th>
                </tr>
              </thead>
              
              	<%
              		for (Livro livro : livros){
				%>
              <tbody>
                <tr>
                  <td><%= livro.getTitulo() %></td>
                  <td><%=livro.getAutores()%></td>
                  <td><%=livro.getGenero()%></td>
                  <td><%=livro.getAno()%></td>
                  <td><%=livro.getEditora()%></td>
                  <td>		

      							<a href="editarLivro.jsp?edid=<%=livro.getId()%>&edtitulo=<%= livro.getTitulo() %>
      							&edgenero=<%=livro.getGenero()%>&edano=<%=livro.getAno()%>&edautores=<%=livro.getAutores()%>
      							&ededitora=<%=livro.getEditora()%>">
      							<button class="btn btn-default" data-toggle="tooltip" title="Editar">
      								<span class="glyphicon glyphicon-pencil" aria-hidden="true" ></span>
                                </button> </a>


                           		 <a href="removerLivro?id=<%= livro.getId() %>">
                            	<button type="button" class="btn btn-default" data-toggle="tooltip" title="Excluir">
                                    <span class="glyphicon glyphicon-remove" aria-hidden="true" ></span>
                                </button> </a>
                                
      		 	</td>
                </tr>
              </tbody>
             <%} %>
            </table>
        </div>

<%@ include file="rodape.html" %>