package br.com.flf.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.flf.jdbc.LivroDao;
import br.com.flf.models.Livro;

@WebServlet("/adicionaLivro")
public class adicionaLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public adicionaLivro() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		PrintWriter out = response.getWriter();
		String titulo = request.getParameter("titulo");
		String autores = request.getParameter("autores");
		String genero = request.getParameter("genero");
		int ano = Integer.parseInt(request.getParameter("ano"));
		String editora = request.getParameter("editora");


		Livro novo_livro = new Livro();
		novo_livro.setTitulo(titulo);
		novo_livro.setAutores(autores);
		novo_livro.setGenero(genero);
		novo_livro.setAno(ano);
		novo_livro.setEditora(editora);

		LivroDao dao = new LivroDao();

		try {
			dao.adiciona(novo_livro);
			out.println("<html>");
			out.println("<body>");
			out.println("Livro: \"" + novo_livro.getTitulo() + 
					"\", adicionado com sucesso!");
			out.println("</body>");
			out.println("</html>");
			response.sendRedirect("listaLivro.jsp");
		} catch (Exception e) {
			out.print(e);
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
