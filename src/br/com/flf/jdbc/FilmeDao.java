package br.com.flf.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.flf.jdbc.Conexao;
import br.com.flf.models.Filme;
import br.com.flf.models.Livro;

/* Código para criação do banco de dados Acervo:
 *  
	mysql -h localhost -u root -p
	
	create database Acervo
	
	use Acervo
	
	create table filme (
		id bigserial primary key,
		titulo VARCHAR(400),
		genero VARCHAR(200),
		lancamento DATE,
		duracao integer,
		imdb real,
		
	);
 
 */



public class FilmeDao {
	
	public FilmeDao() {
		
	}
    // Conectar ao banco
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
    		stmt.setDate(5, new java.sql.Date(novo.getLancamento().getTimeInMillis()));
    		// executa
    		stmt.execute();
    		stmt.close();
    	} catch (SQLException e) {
    		throw new RuntimeException(e);
    	}
    	
    	conx.close(conn);
    	}
    
    public List<Filme> getLista() throws Exception{
    	List<Filme> filmes = new ArrayList<Filme>();

    	try {
        	Conexao conx = new Conexao();
    		Connection conn = conx.abrir();
    		PreparedStatement stmt = conn.prepareStatement("select * from filme");
    		ResultSet rs = stmt.executeQuery();

    		while (rs.next()) {
    			// criando o objeto Contato
    			Filme record = new Filme();
    			record.setId(rs.getInt("id"));
    			record.setTitulo(rs.getString("titulo"));
                record.setDuracao(rs.getInt("duracao"));
                record.setGenero(rs.getString("genero"));
                record.setImdb(rs.getFloat("imdb"));
                
    			//... inserir outros dados!!!

    			// montando a data através do Calendar
    			Calendar data = Calendar.getInstance();
    			data.setTime(rs.getDate("lancamento"));
    			record.setLancamento(data);

    			// adicionando o objeto à lista
    			filmes.add(record);
    		}
    		rs.close();
    		stmt.close();
    		conx.close(conn);
    		return filmes;
    	} catch (SQLException e) {
    		throw new RuntimeException(e);
    	}

    }
    
    public List<Filme> getPesquisa(String key) throws Exception{
    	List<Filme> filmes = new ArrayList<Filme>();

    	try {
        	Conexao conx = new Conexao();
    		Connection conn = conx.abrir();
    		PreparedStatement stmt = conn.prepareStatement("select * from filme where genero like ?");
    		stmt.setString(1,key);
    		ResultSet rs = stmt.executeQuery();

    		while (rs.next()) {
    			// criando o objeto Contato
    			Filme record = new Filme();
    			record.setTitulo(rs.getString("titulo"));
                record.setDuracao(rs.getInt("duracao"));
                //record.setGenero(rs.getString("genero"));
                //record.setImdb(rs.getFloat("imdb"));
                
    			//... inserir outros dados!!!

    			// montando a data através do Calendar
    			Calendar data = Calendar.getInstance();
    			data.setTime(rs.getDate("lancamento"));
    			record.setLancamento(data);

    			// adicionando o objeto à lista
    			filmes.add(record);
    		}
    		rs.close();
    		stmt.close();
    		conx.close(conn);
    		return filmes;
    	} catch (SQLException e) {
    		throw new RuntimeException(e);
    	}

    }
    
	public void excluir(Filme novo) throws Exception {
		Conexao conx = new Conexao();
		Connection conn = conx.abrir();

		String sql = "delete from filme where id=?";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, novo.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		conx.close(conn);
	}
	
	public void editar(Filme novo) throws Exception {
		Conexao conx = new Conexao();
		Connection conn = conx.abrir();

		String sql = "update filme set titulo=?, genero=?, duracao=?,imdb=?,lancamento=? where id=?";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, novo.getTitulo());
			stmt.setString(2, novo.getGenero());
			stmt.setInt(3, novo.getDuracao());
			stmt.setFloat(4, novo.getImdb());
			stmt.setDate(5, new java.sql.Date(novo.getLancamento().getTimeInMillis()));
			stmt.setLong(6, novo.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
        
}
