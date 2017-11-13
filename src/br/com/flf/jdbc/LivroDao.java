package br.com.flf.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.flf.models.Livro;

public class LivroDao {
	public LivroDao() {

	}

	public void adiciona(Livro novo) throws Exception {
		Conexao conx = new Conexao();
		Connection conn = conx.abrir();

		String sql = "insert into livro " + "(titulo,autores,genero,ano,editora)" + " values (?,?,?,?,?)";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, novo.getTitulo());
			stmt.setString(2, novo.getAutores());
			stmt.setString(3, novo.getGenero());
			stmt.setInt(4, novo.getAno());
			stmt.setString(5, novo.getEditora());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		conx.close(conn);

	}

	public void excluir(Livro novo) throws Exception {
		Conexao conx = new Conexao();
		Connection conn = conx.abrir();

		String sql = "delete from livro where id=?";

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

	public void editar(Livro novo) throws Exception {
		Conexao conx = new Conexao();
		Connection conn = conx.abrir();

		String sql = "update livro set titulo=?, autores=?, genero=?,ano=?,editora=? where id=?";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, novo.getTitulo());
			stmt.setString(2, novo.getAutores());
			stmt.setString(3, novo.getGenero());
			stmt.setInt(4, novo.getAno());
			stmt.setString(5, novo.getEditora());
			stmt.setLong(6, novo.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public List<Livro> getLista() throws Exception {
		List<Livro> livros = new ArrayList<Livro>();

		try {
			Conexao conx = new Conexao();
			Connection conn = conx.abrir();
			PreparedStatement stmt = conn.prepareStatement("select * from livro");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Livro record = new Livro();
				record.setId(rs.getInt("id"));
				record.setTitulo(rs.getString("titulo"));
				record.setAutores(rs.getString("autores"));
				record.setGenero(rs.getString("genero"));
				record.setAno(rs.getInt("ano"));
				record.setEditora(rs.getString("editora"));

				livros.add(record);
			}
			rs.close();
			stmt.close();
			conx.close(conn);
			return livros;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Livro> getPesquisa(String key) throws Exception {
		List<Livro> livros = new ArrayList<Livro>();

		try {
			Conexao conx = new Conexao();
			Connection conn = conx.abrir();
			PreparedStatement stmt = conn.prepareStatement("select * from livro where genero like ?");
			stmt.setString(1, key);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Livro record = new Livro();
				record.setTitulo(rs.getString("titulo"));

				livros.add(record);
			}
			rs.close();
			stmt.close();
			conx.close(conn);
			return livros;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
