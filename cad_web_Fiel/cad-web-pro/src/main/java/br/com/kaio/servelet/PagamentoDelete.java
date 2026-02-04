package br.com.kaio.servelet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.kaio.domain.Pagamento;
import br.com.kaio.persistence.dao.PagamentoDao;

@WebServlet("/PagamentoDelete")
public class PagamentoDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			String cpf = request.getParameter("cpf");

			Pagamento pg = new Pagamento();
			pg.setId(id);
			pg.setCpf(cpf);

			PagamentoDao dao = new PagamentoDao();
			dao.apagar(pg);

			RequestDispatcher rd = request.getRequestDispatcher("Pagamentos.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
