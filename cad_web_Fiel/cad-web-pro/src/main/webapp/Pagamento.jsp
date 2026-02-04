<%@page import="br.com.kaio.domain.PagamentoFiel"%>
<%@page import="java.security.DomainCombiner"%>
<%@page import="br.com.kaio.persistence.dao.PagamentoDao"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="br.com.kaio.persistence.dao.FielDao"%>
<%@page import="br.com.kaio.domain.Fiel"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>

<%
Date agora = new Date();
//O formato para o <input type="date"> TEM de ser yyyy-MM-dd
SimpleDateFormat sdfInput = new SimpleDateFormat("yyyy-MM-dd");
String dataAtualParaInput = sdfInput.format(agora);

PagamentoFiel pgf = new PagamentoFiel();
FielDao dao = new FielDao();
Fiel fiel = null;
String cpfParam = request.getParameter("cpf");
if (cpfParam != null) {
	fiel = new FielDao().pegar(cpfParam);
}
List<Fiel> listaFiel = dao.listar();
String valorDataInput = dataAtualParaInput;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<title>Formulário de pagamento</title>
</head>
<body>
	<div class="boxAgenda">
		<h1>Formulário de pagamento</h1>
		<hr>
		<form
			action="<%=fiel == null ? "pagamentoinsert" : "pagamentoupdate"%>"
			method="post">

			<label>Selecione o Fiel:</label> <select name="cpf" id="cpfSelect"
				required>
				<option value="">-- Selecione --</option>

				<%
				for (Fiel f : listaFiel) {
				%>
				<option value="<%=f.getCpf()%>">
					<%=f.getNome()%> -
					<%=f.getCpf()%>
				</option>
				<%
				}
				%>
			</select> <label>VALOR</label> <input type="number" name="valor" step="0.01"
				required> <label>DATA DE PAGAMENTO</label> <input
				type="date" name="datapagamento" value="<%=valorDataInput%>"
				required>


			<button type="submit" style="color: #fff;">Cadastrar</button>
		</form>
	</div>

	<script>
    function onlyOne(checkbox) {
        const checkboxes = document.getElementsByName('status')
        checkboxes.forEach((item) => {
            if (item !== checkbox) item.checked = false
        })
    }
    </script>
</body>
</html>
