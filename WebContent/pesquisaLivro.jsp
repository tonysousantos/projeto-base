<%@ page language="java" import="java.sql.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ include file="cabecalho.html" %>

    <div class="page-header">
        <h1>Pesquisa de Livros</h1>
    </div>
<div>
    <form class="form-inline" name="form_busca" method="post" action="">
        <div class="form-group" align="center">
            <input type="text" class="form-control" name="pesquisa"
                   placeholder="Pesquise informando Titulo ou G�nero do filme" size="100">
        </div>
        <button type="submit" class="btn btn-default">
            <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
        </button>

    </form>
    </div>
      <br>
        <div class="row ">
        	<div class="col-md-12">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>Titulo</th>
                  <th>Autores</th>
                  <th>G�nero</th>
                  <th>Ano</th>
                  <th>Editora</th>
                </tr>
              </thead>

<% 
try{
	// 1 - Carregar o driver
	Class.forName("org.postgresql.Driver");
	//out.println("</br>Conseguiu carregar o driver");
	
	Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Acervo","postgres","123456");
	Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
	ResultSet rs = null;
	
	String sql;
	sql = "select * from livro where upper(titulo) like upper('"+request.getParameter("pesquisa")+"%') or upper(genero) like upper('"+request.getParameter("pesquisa")+"%')";
	rs = st.executeQuery(sql);
	
	while(rs.next()){
		%>

              <tbody>
                <tr>
                  <td><%= rs.getString("titulo") %></td>
                  <td><%= rs.getString("autores") %></td>
                  <td><%= rs.getString("genero") %></td>
                  <td><%= rs.getString("ano") %></td>
                  <td><%= rs.getString("editora") %></td>

                </tr>
              </tbody>
      <%}
}
catch (ClassNotFoundException erroClass){
	out.println("<br>Classe Driver jdbc n�o foi localizado, erro"+erroClass);
}

catch (SQLException erroSQL){
	out.println("Erro de conex�o com o banco de dados, erro"+erroSQL);
}

%>
            </table>
        </div>

<%@ include file="rodape.html" %>