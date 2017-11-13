package br.com.flf.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.flf.models.Filme;

public class Conexao {

    private static final String USUARIO = "postgres";
    private static final String SENHA = "123456";
    private static final String URL = "jdbc:postgresql://localhost:5432/Acervo";
    private static final String DRIVER = "org.postgresql.Driver";

    // Conectar ao banco
    public Connection abrir() throws Exception {
        // Registrar o driver
        Class.forName(DRIVER);
        // Capturar a conexão
        Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
        // Retorna a conexao aberta
        return conn;
    }


        public void adiciona(Filme novo) throws Exception {
        	Conexao conx = new Conexao();
        	Connection conn = conx.abrir();

        	String sql = "insert into filme " +
        	"(titulo,genero,duracao,imdb,lancamento)" +
        	" values (?,?,?,?,?)";
        	try {
        	// prepared statement para inserção
        	PreparedStatement stmt = conn.prepareStatement(sql);
        	// seta os valores
        	stmt.setString(1,novo.getTitulo());
        	stmt.setString(2,novo.getGenero());
        	stmt.setInt(3,novo.getDuracao());
        	stmt.setFloat(4, novo.getImdb());
        	stmt.setDate(5,new java.sql.Date(novo.getLancamento().getTimeInMillis()));

        	// executa
        	stmt.execute();
        	stmt.close();
        	} catch (SQLException e) {
        	throw new RuntimeException(e);
        	}
    }
            public void close(Connection conn) throws Exception {
                conn.close();
            }
}