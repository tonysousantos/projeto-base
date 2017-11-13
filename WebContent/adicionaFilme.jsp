<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ include file="cabecalho.html" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	
<div class="container theme-showcase" role="main">

    <div class="page-header">
        <h1>Cadastrar Filme</h1>
    </div>   

    </div>

    <div class="row">
        <div class="col-md-12">
            <form class="form-horizontal" method="post" action="adicionaFilme">

                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">TITULO: </label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" name="titulo" placeholder="Titulo">
                    </div>
                </div>

				<div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">GENERO: </label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" name="genero" placeholder="Genero">
                    </div>
                </div>

				<div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">DURAÇÃO: </label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" name="duracao" placeholder="Duração">
                    </div>
                </div>

				<div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">IMDB: </label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" name="imdb" placeholder="Imdb">
                    </div>
                </div>
                
                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">LANÇAMENTO: </label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" name="lancamento" id="dataLancamento" placeholder="Lançamento">
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