<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ include file="cabecalho.html" %>   
 
<%@ page import="java.util.Date" %>
<%@ page import="br.com.flf.jdbc.FilmeDao" %>
<%@ page import="br.com.flf.models.Filme" %>
<%@ page import="java.util.List"  %>
<%@ page import="java.text.DateFormat"  %>
<%@ page import="java.text.SimpleDateFormat"  %>
<%@ page import="java.text.*"  %>

   
<div class="container theme-showcase" role="main">

    <div class="page-header">
        <h1>Editar Filme</h1>
    </div>   

    </div>


    <div class="row">
        <div class="col-md-12">
            <form class="form-horizontal" method="post" action="editarFilme">

			<input type="hidden" name="id" value="<%= request.getParameter("edid") %>">

                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">TITULO: </label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" name="titulo" placeholder="Titulo"
                         value="<%= request.getParameter("edtitulo").trim() %>" >
                    </div>
                </div>

				<div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">GENERO: </label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" name="genero" placeholder="Genero" 
                        value="<%= request.getParameter("edgenero").trim() %>">
                    </div>
                </div>

				<div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">DURAÇÃO: </label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" name="duracao" placeholder="Duração" 
                        value="<%= request.getParameter("edduracao").trim() %>">
                    </div>
                </div>

				<div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">IMDB: </label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" name="imdb" placeholder="Imdb" 
                        value="<%= request.getParameter("edimdb").trim() %>">
                    </div>
                </div>
                
                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">LANÇAMENTO: </label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" name="lancamento" placeholder="Lançamento" 
                        value="<%= request.getParameter("edlancamento").trim() %>">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button class="btn btn-primary" data-toggle="tooltip" title="Concluir">
                            <span class="glyphicon glyphicon-ok" aria-hidden="true" ></span> &nbsp;&nbsp;OK
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>

</div> <!-- /container -->

<%@ include file="rodape.html" %>