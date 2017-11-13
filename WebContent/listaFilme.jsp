<%@ page language="java" import="java.sql.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ include file="cabecalho.html" %>

<%@ page import="java.util.Date" %>
<%@ page import="br.com.flf.jdbc.FilmeDao" %>
<%@ page import="br.com.flf.models.Filme" %>
<%@ page import="java.util.List"  %>
<%@ page import="java.text.DateFormat"  %>
<%@ page import="java.text.SimpleDateFormat"  %>


<% DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); %>

<%
FilmeDao dao = new FilmeDao();
List<Filme> filmes = dao.getLista();
%>
    <div class="page-header">
        <h1>Lista de Filmes</h1>
    </div>

   <div class="row">
        <div class="col-sm-7 col-sm-offset-5 col-md-12 col-md-offset-0 main">
                     
                <a href="adicionaFilme.jsp">
                   <button class="btn btn-primary pull-right" data-toggle="tooltip" title="Novo">
                        <span class="glyphicon glyphicon-log-in" aria-hidden="true" ></span>
                    </button> </a>
                
                <a href="pesquisaFilme.jsp">
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
                  <th>Gênero</th>
                  <th>Lançamento</th>
                  <th>IMD</th>
                  <th>Duração</th>
                  <th>Ação</th>
                </tr>
              </thead>
              
              	<%
					for (Filme filme : filmes){
				%>
              <tbody>
                <tr>
                  <td><%= filme.getTitulo() %></td>
                  <td><%= filme.getGenero() %></td>
                  <td><%= formatter.format(filme.getLancamento().getTime()) %></td>
                  <td><%= filme.getImdb() %></td>
                  <td><%= filme.getDuracao() %></td>
                  <td>		

      							<a href="editarFilme.jsp?edid=<%=filme.getId()%>&edtitulo=<%=filme.getTitulo()%>
      							&edgenero=<%= filme.getGenero() %>&edimdb=<%= filme.getImdb() %>&edduracao=<%=filme.getDuracao()%>
      							&edlancamento=<%= formatter.format(filme.getLancamento().getTime()) %>">
      							<button class="btn btn-default" data-toggle="tooltip" title="Editar">
      								<span class="glyphicon glyphicon-pencil" aria-hidden="true" ></span>
                                </button> </a>


                           		 <a href="removerFilme?id=<%= filme.getId() %>">
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