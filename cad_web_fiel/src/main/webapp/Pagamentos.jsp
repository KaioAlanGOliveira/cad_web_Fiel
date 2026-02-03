
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.com.kaio.persistence.dao.PagamentoDao"%>
<%@page import="br.com.kaio.domain.Fiel"%>
<%@page import="br.com.kaio.persistence.dao.FielDao"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="br.com.kaio.domain.PagamentoFiel"%>
<%@page import="java.util.List"%>
<%
List<PagamentoFiel> lista = new PagamentoDao().Listar();

PagamentoFiel pgf = new PagamentoFiel();

String dataFormatada = "";
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">

<title>Pagamentos</title>
</head>
<body>


	<div class="boxAgenda">
		<h1>Cadastro de pagamentos</h1>


	</div>
	<div class="boxAgenda">
		<div style="margin-left: 60rem;"></div>
		<a href="index.html"
			style="text-decoration: none; border-radius: 20rem;"> Voltar</a> <br>
		<br> <a href="Pagamento.jsp" style="text-decoration: none;">Adicionar</a>
		<br /> <br> <br>
		<table>

			<thead>
				<tr>
					<th width="100px">ID</th>
					<th width="100px">CPF</th>
					<th width="100px">NOME</th>
					<th width="200px">VALOR</th>
					<th width="100px">DATAPAGAMENTO</th>
					<th width="100px">Alterar</th>
					<th width="100px">Remover</th>
				</tr>
			</thead>
			<tbody>

				<%
				for (PagamentoFiel pg : lista) {
				    String dataItem = (pg.getDataPagamento() != null) ? sdf.format(pg.getDataPagamento()) : "";

				%>
				<tr>
					<td><%=pg.getId()%></td>
					<td><%=pg.getCpf()%></td>
					<td><%=pg.getNomeFiel()%></td>
					<td><%=pg.getValor()%></td>
					<td align="center"><%=dataItem%></td>
					<td align="center"><a
						href="Pagamento.jsp?cpf=<%=pg.getCpf()%>">alterar</a></td>
					<td align="center"><a
						href="PagamentoDelete?id=<%=pg.getId()%>&cpf=<%=pg.getCpf()%>"
						style="background-color: red;">remover</a></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>