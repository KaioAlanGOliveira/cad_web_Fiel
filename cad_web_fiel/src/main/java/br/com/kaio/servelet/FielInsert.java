package br.com.kaio.servelet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.kaio.domain.Fiel;
import br.com.kaio.persistence.dao.FielDao;

@WebServlet("/fielinsert")
public class FielInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String cpf = request.getParameter("cpf");
			String nome = request.getParameter("nome");
			int idade = Integer.parseInt(request.getParameter("idade"));
			int fone = Integer.parseInt(request.getParameter("fone"));

			Fiel f = new Fiel();

			f.setCpf(cpf);
			f.setNome(nome);
			f.setIdade(idade);
			f.setTelefone(fone);

			FielDao dao = new FielDao();
			dao.adicionar(f);
			
			RequestDispatcher rd = request.getRequestDispatcher("fieis.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
