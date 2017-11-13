package br.com.flf.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.flf.jdbc.FilmeDao;
import br.com.flf.models.Filme;

@WebServlet("/editarFilme")
public class editarFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public editarFilme() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		PrintWriter out = response.getWriter();
		long id = Long.parseLong(request.getParameter("id"));
		String titulo = request.getParameter("titulo");
		String genero = request.getParameter("genero");
		int duracao = Integer.parseInt(request.getParameter("duracao"));
		float imdb = Float.parseFloat(request.getParameter("imdb"));
		String lancamento = request.getParameter("lancamento");
		Calendar data = null;

		try {
			Date date_lanc = (Date) new SimpleDateFormat("dd/mm/yyyy").parse(lancamento);
			data = Calendar.getInstance();
			data.setTime(date_lanc);
		} catch (ParseException e) {
			out.println("Erro de conversão da data");
			return;
		}

		Filme novo_filme = new Filme();
		novo_filme.setId(id);
		novo_filme.setTitulo(titulo);
		novo_filme.setGenero(genero);
		novo_filme.setDuracao(duracao);
		novo_filme.setImdb(imdb);
		novo_filme.setLancamento(data);

		FilmeDao dao = new FilmeDao();

		try {
			dao.editar(novo_filme);
			out.println("<html>");
			out.println("<body>");
			out.println("Filme: \"" + novo_filme.getTitulo() + "\", editado com sucesso!");
			out.println("</body>");
			out.println("</html>");
			response.sendRedirect("listaFilme.jsp");
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
