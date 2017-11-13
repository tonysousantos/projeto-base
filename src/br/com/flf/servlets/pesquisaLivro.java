package br.com.flf.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.flf.jdbc.LivroDao;
import br.com.flf.models.Livro;

@WebServlet("/pesquisaLivro")
public class pesquisaLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public pesquisaLivro() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String pesquisa = request.getParameter("key");
		LivroDao dao = new LivroDao();
		List<Livro> result = new ArrayList<Livro>();
		try {
			result = dao.getPesquisa(pesquisa);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("lista_req", result);
		RequestDispatcher disp = request.getRequestDispatcher("dadosPESQ.jsp");
		disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
