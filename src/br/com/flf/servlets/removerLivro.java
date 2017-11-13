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

@WebServlet("/removerLivro")
public class removerLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public removerLivro() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out = response.getWriter();
		Livro novo_livro = new Livro();
		LivroDao dao = new LivroDao();

		long id = Long.parseLong(request.getParameter("id"));
		novo_livro.setId(id);

		try {
			dao.excluir(novo_livro);
			out.println("<html>");
			out.println("<body>");
			out.println("Filme removido com sucesso!");
			out.println("</body>");
			out.println("</html>");
			response.sendRedirect("listaLivro.jsp");
		} catch (Exception e) {
			out.print(e);
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}