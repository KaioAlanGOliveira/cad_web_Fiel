<%@page import="br.com.kaio.persistence.dao.FielDao"%>
<%@page import="java.util.List"%>
<%@page import="br.com.kaio.domain.Fiel"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<Fiel> fieis = new FielDao().listar();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">

<title>Agenda</title>
</head>
<body>

	<div class="boxAgenda">
		<h1>Cadastro de Fieis</h1>
		<a href="index.html"> Voltar</a> <br> <br> <a
			href="fiel.jsp">Adicionar</a> <br />
		<table>
			<thead>
				<tr>
					<th width="100px">CPF</th>
					<th width="400px">Nome</th>
					<th width="100px">idade</th>
					<th width="100px">fone</th>
					<th width="100px">Alterar</th>
					<th width="100px">Remover</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (Fiel p : fieis) {
				%>
				<tr>
					<td><%=p.getCpf()%></td>
					<td><%=p.getNome()%></td>
					<td align="center"><%=p.getIdade()%></td>
					<td align="center"><%=p.getTelefone()%></td>
					<td align="center"><a href="fiel.jsp?cpf=<%=p.getCpf()%>">alterar</a></td>
					<td align="center"><a href="FielDelete?cpf=<%=p.getCpf()%>" style="background-color: red;">remover</a></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>