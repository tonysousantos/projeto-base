package br.com.flf.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.flf.jdbc.LivroDao;
import br.com.flf.models.Livro;

@WebServlet("/listarLivro")
public class listarLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public listarLivro() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		LivroDao dao = new LivroDao();
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		try {
			List<Livro> livros = dao.getLista();
			for (int i = 0; i < livros.size(); i++) {
				out.println("<li>" + livros.get(i).getTitulo() + "</li");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.println("</html>");
		out.println("</body>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
