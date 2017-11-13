package br.com.flf.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.flf.jdbc.FilmeDao;
import br.com.flf.jdbc.LivroDao;
import br.com.flf.models.Filme;
import br.com.flf.models.Livro;

@WebServlet("/removerFilme")
public class removerFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public removerFilme() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		PrintWriter out = response.getWriter();
		Filme novo_filme = new Filme();
		FilmeDao dao = new FilmeDao();

		long id = Long.parseLong(request.getParameter("id"));
		novo_filme.setId(id);

		try {
			dao.excluir(novo_filme);
			out.println("<html>");
			out.println("<body>");
			out.println("Filme removido com sucesso!");
			out.println("</body>");
			out.println("</html>");
			response.sendRedirect("listaFilme.jsp");
		} catch (Exception e) {
			out.print(e);
			e.printStackTrace();
		}
	}
}
