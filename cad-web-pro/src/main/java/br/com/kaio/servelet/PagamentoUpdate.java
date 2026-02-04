package br.com.kaio.servelet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.kaio.domain.Pagamento;
import br.com.kaio.persistence.dao.PagamentoDao;

@WebServlet("/pagamentoupdate")
public class PagamentoUpdate extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String cpf = request.getParameter("cpf");
			String valor = request.getParameter("valor");
			String dataPagamento = request.getParameter("datapagamento");
			
			BigDecimal valorDecimal = new BigDecimal(valor);
			Date data = Date.valueOf(dataPagamento);

			Pagamento pg = new Pagamento();
			pg.setCpf(cpf);
			pg.setValor(valorDecimal);
			pg.setDataPagamento(data);

			PagamentoDao dao = new PagamentoDao();
			dao.editar(pg);

			RequestDispatcher rd = request.getRequestDispatcher("Pagamentos.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
